package my.interview.questions;

public class MyStack {

	private Link link = null;
	
	public Object push(Object item) {
		Link linkItem = new Link();
		linkItem.data = item;
		linkItem.next = link;
		link = linkItem;
		
		return link;
	}
	
	public Object pop () {
		Object item = null;
		
		if (null != link) {
			item = link.data;
			link = link.next;
		}
		
		return item;
	}
	
	public Object peek() {
		return null == link ? null : link.data;
	}
	
	public static void main(String[] args) {
	   	 MyStack ms = new MyStack();
	   	 
	   	 ms.push("one");
	   	 ms.push("two");
	   	 
	   	 try
	   	 {
	   		 assert "two".equals(ms.peek());
	   		 assert "two".equals(ms.pop());
	   		 assert "one".equals(ms.pop());
	   	 }
	   	 catch(Exception e )
	   	 {
	   		 
	   	 }
	}

	class Link {
		Object data;
		Link next;
	}
}
