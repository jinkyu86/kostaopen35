package kr.or.kosta.bookchange.member;

public class Block {

	public Member member;
	private Member blockmember;
	public BlockCondition blockCondition;
	/**
	 * �Ű��ȣ
	 */
	private int blockNo;
	/**
	 * �Ű���
	 */
	private String blockContent;

	
	public Member getBlockmember() {
		return blockmember;
	}

	public void setBlockmember(Member blockmember) {
		this.blockmember = blockmember;
	}
	

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public BlockCondition getBlockCondition() {
		return blockCondition;
	}

	public void setBlockCondition(BlockCondition blockCondition) {
		this.blockCondition = blockCondition;
	}

	public int getBlockNo() {
		return blockNo;
	}

	public void setBlockNo(int blockNo) {
		this.blockNo = blockNo;
	}

	public String getBlockContent() {
		return blockContent;
	}

	public void setBlockContent(String blockContent) {
		this.blockContent = blockContent;
	}
	@Override
	public String toString() {
		return "Block [member=" + member + ", blockCondition=" + blockCondition
				+ ", blockNo=" + blockNo + ", blockContent=" + blockContent
				+ "]";
	}

}
