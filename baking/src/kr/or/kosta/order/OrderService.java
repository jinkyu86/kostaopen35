package kr.or.kosta.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ModelDriven;

import kr.or.kosta.good.Good;
import kr.or.kosta.good.GoodDAO;
import kr.or.kosta.good.IGoodDAO;
import kr.or.kosta.member.IMemberDAO;
import kr.or.kosta.member.Member;
import kr.or.kosta.member.MemberDAO;

public class OrderService implements ModelDriven, SessionAware{
	private IOrderDAO orderDAO;
	private IMemberDAO memberDAO;
	private IGoodDAO goodDAO;
	
	private Order order;
	private Map session;
	private List<Order> ORDERLIST;
	private String memberid;
	private int orderNum;
	private Good good;
	private int goodNum;
	private List<Order> cartList;
	private int putedBuyIndex;
	private Order putedBuy;
	private int qty;
	private Member member;
	private int index;
	

	public OrderService(IOrderDAO orderDAO, IMemberDAO memberDAO,
			IGoodDAO goodDAO) {
		super();
		this.orderDAO = orderDAO;
		this.memberDAO = memberDAO;
		this.goodDAO = goodDAO;
	}

	public String CartList() throws Exception{
		return "success";
	}

	public String viewCartList() throws Exception{
		
		
		good=goodDAO.selectGood(order.getGood().getGoodNum());
		
		order=new Order();
		order.setGood(good);
		order.setQty(2);
		cartList=null;
		putedBuyIndex=-1;
		
		if(session.get("CART_LIST")==null){
			cartList=new ArrayList<Order>();
		}else{
			cartList=(List)session.get("CART_LIST");
			for(int i=0; i<cartList.size(); i++){
				putedBuy=cartList.get(i);
				if(putedBuy.getGood().getGoodNum()==3){
					putedBuyIndex=i;
					break;
				}
			}
		}
		if(putedBuyIndex==-1){
			cartList.add(order);
		}else{
			Order putedBuy=cartList.get(putedBuyIndex);
			putedBuy.setQty(putedBuy.getQty()+2);
			cartList.set(putedBuyIndex, putedBuy);
		}
		session.put("CART_LIST",cartList);
		return "success";
	}

	//아이디를 이용한 주문리스트 조회
	public String viewOrderList() throws Exception{
		memberid="rabin";
		ORDERLIST=orderDAO.selectOrderList(memberid);
		session.put("ORDER_LIST",ORDERLIST);
		return "success";
	}

	//주문확인
	public String viewOrder() throws Exception{
		order=orderDAO.selectOrder(orderNum);
		return "success";
	}

	//주문하기
	public String addOrder() throws Exception{
		cartList=(List)session.get("CART_LIST");
		for(int i=0; i<cartList.size(); i++){
			order=cartList.get(i);
			order.setMember(member);
			good=goodDAO.selectGood(order.getGood().getGoodNum());
			good.setQty(good.getQty()-order.getQty());
			goodDAO.updateGood(good);
			orderDAO.insertOrder(order);
		}
		session.remove("CART_LIST");
		return "success";
	}

	//주문하기
	public String addOrderForm() throws Exception{
		member=(Member)session.get("member");
//		if(member==null){
//			return "/member/loginForm";
//		}
		member=new Member();
		member=memberDAO.selsctMember("rabin");
		session.put("MEMBER", member);
		return "success";
	}

	//장바구니 삭제
	public String removeCart() throws Exception{
		ORDERLIST=(List)session.get("CART_LIST");
		order=ORDERLIST.get(index);
		if(order.getQty()==1){
			ORDERLIST.remove(index);
		}else{
			qty=order.getQty();
			order.setQty(qty-1);
			ORDERLIST.set(index, order);
		}
		session.put("CART_LIST", ORDERLIST);
		return "success";
	}
	
	//장바구니수정
	public String editCart() throws Exception{
		cartList=(List)session.get("CART_LIST");
		order=cartList.get(index);
		order.setQty(qty);
		cartList.set(index,order);
		session.put("CART_LIST", cartList);
		return "success";
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public Order getPutedBuy() {
		return putedBuy;
	}
	public void setPutedBuy(Order putedBuy) {
		this.putedBuy = putedBuy;
	}
	public int getPutedBuyIndex() {
		return putedBuyIndex;
	}
	public void setPutedBuyIndex(int putedBuyIndex) {
		this.putedBuyIndex = putedBuyIndex;
	}
	public List<Order> getCartList() {
		return cartList;
	}
	public void setCartList(List<Order> cartList) {
		this.cartList = cartList;
	}
	public int getGoodNum() {
		return goodNum;
	}
	public void setGoodNum(int goodNum) {
		this.goodNum = goodNum;
	}
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public List<Order> getORDERLIST() {
		return ORDERLIST;
	}
	public void setORDERLIST(List<Order> oRDERLIST) {
		ORDERLIST = oRDERLIST;
	}
	public Map getSession() {
		return session;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	@Override
	public Object getModel() {
		return order;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	public OrderService(){
		super();
	}
}
