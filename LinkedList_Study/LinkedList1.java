package LinkedList_Study;


public class LinkedList1 {
	private Node first;
	private Node last;
	
	private int  size=0;
	
	public void add(Object obj) {
		Node node=new Node(obj);
		size++;
		if(first==null) {
			node.previous=null;
			node.next=null;
			
			first=node;
			last=node;
		}
		else {
			node.previous=last;
			node.next=null;
			
			last.next=node;
			last=node;
		}
		
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append('[');
		Node temp=first;
		while(temp!=null) {
			sb.append(temp.element+",");
			temp=temp.next;
		}
		sb.setCharAt((sb.length()-1), ']');
		return sb.toString();
	}
	
	public Object get(int index) {
		if(index>size-1||size<0)
			throw new RuntimeException("索引不合法"+index);
		Node temp=first;
		for (int i=0;i<index;i++) {
			temp=temp.next;
		}
		return temp.element;
		
	}
	public void remove(Object e) {
		boolean flag=true;
		Node temp=first;
		for(int i=0;i<size;i++) {
			temp=temp.next;
			if(temp.element.equals(e)){
				temp.previous.next=temp.next;
				temp.next.previous=temp.previous;
				flag=false;
				break;
			}
				
			
		}
		if(flag)
			throw new RuntimeException("Not Find Element");
	}
	
	
	public void erase(int index) {
		if(index<0||index>size-1)
			throw new RuntimeException("越界");
		
		if(index==0) {
			first=first.next;
			
		}
		else {
			Node temp=first;
			for(int i=0;i<index;i++)
			temp=temp.next;
		
			temp.previous.next=temp.next;
			temp.next.previous=temp.previous;
		}
	}
	
	
	
	public Node getNode(int index) {
		Node temp=first;
		for(int i=0;i<index;i++)
			temp=temp.next;
		return temp;
		
	}
	
	
	
	public void insert(Object e,int index) {
		
		if(index==0)
		{
			Node newNode=new Node(e);
			Node temp=first;
			newNode.previous=null;
			first=newNode;
			temp.previous=newNode;
			newNode.next=temp;
		}	
		else{
			Node newNode=new Node(e);
		
		Node temp=getNode(index);
		
		Node up=temp.previous;
		up.next=newNode;
		newNode.previous=up;
		newNode.next=temp;
		temp.previous=newNode;
		
		
			}
		
	}
	
	
	public static void main(String[] args) {
		LinkedList1 list=new LinkedList1();
		list.add("a");
		list.add("b");
		list.add("c");
		list.erase(0);
		System.out.println(list);
	}
}

