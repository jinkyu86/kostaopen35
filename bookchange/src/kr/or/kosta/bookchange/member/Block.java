package kr.or.kosta.bookchange.member;

public class Block {

	private Member member;
	private Member blockmember;
	private BlockCondition blockCondition;
	/**
	 * 신고번호
	 */
	private int blockNo;
	/**
	 * 신고내용
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



	public String getBlockConditionIng() {
		return blockCondition.getBlockConditionIng();
	}

	public void setBlockConditionIng(String blockConditionIng) {
		blockCondition.setBlockConditionIng(blockConditionIng);
	}

	public int hashCode() {
		return blockCondition.hashCode();
	}

	public boolean equals(Object obj) {
		return blockCondition.equals(obj);
	}

	@Override
	public String toString() {
		return "Block [member=" + member + ", blockmember=" + blockmember
				+ ", blockCondition=" + blockCondition + ", blockNo=" + blockNo
				+ ", blockContent=" + blockContent + "]";
	}


	
}



