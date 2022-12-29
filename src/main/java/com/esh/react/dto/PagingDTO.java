package com.esh.react.dto;

public class PagingDTO {
	
	// 현재페이지, 페이지당 글 갯수, SQL쿼리에 쓸 start, end
		private int nowPage, cntPerPage, start, end;
		
		public PagingDTO() {
		}
		public PagingDTO(int total, int nowPage, int cntPerPage) {
			setNowPage(nowPage);
			setCntPerPage(cntPerPage);
			calcStartEnd(getNowPage(), getCntPerPage());
		}
		
		// DB 쿼리에서 사용할 start, end값 계산
		public void calcStartEnd(int nowPage, int cntPerPage) {
			setEnd(nowPage * cntPerPage);
			setStart(getEnd() - cntPerPage + 1);
		}
		
		public int getNowPage() {
			return nowPage;
		}
		public void setNowPage(int nowPage) {
			this.nowPage = nowPage;
		}
		
		public int getCntPerPage() {
			return cntPerPage;
		}
		public void setCntPerPage(int cntPerPage) {
			this.cntPerPage = cntPerPage;
		}
		
		public int getStart() {
			return start;
		}
		public void setStart(int start) {
			this.start = start;
		}
		public int getEnd() {
			return end;
		}
		public void setEnd(int end) {
			this.end = end;
		}	
		
		@Override
		public String toString() {
			return "PagingDTO [nowPage=" + nowPage + ", cntPerPage=" + cntPerPage + ", start=" + start + ", end=" + end + "]";
		}
		
		
}
