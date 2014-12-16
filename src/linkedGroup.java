
public class linkedGroup {

	public Node header;
	public int size;
    
    public linkedGroup(){
        
        header = new Node(null);
        size = 0;
    }
    
    // 단순 연결 리스트 노드
    public class Node{
        
        public String data;
        public Node nextNode;
        
        Node(String data){
            
            this.data = data;
            this.nextNode = null;
        }
        
    }
    
    // index 위치의 노드 데이터를 반환한다.
    public String get(int index){
    	return getNode(index).data;
    	
    }
    
    // index 위치의 노드를 반환한다.
    public Node getNode(int index){
        
        if(index < 0 ){
            throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + size);
        }
        
        Node node = header.nextNode;
      //  System.out.println("node.data" + node);
        for(int i =0; i < index ; i++){
            node = node.nextNode;
        }
        
        return node;
    }
    
    // 첫번째 노드의 데이터를 반환한다.
    public String getFirst(){
        return get(0);
    }
    
    // 해당 데이터의 노드 위치 index를 반환한다.
    public int getNodeIndex(String obj){
        
        if(size<=0){
            return -1;
        }
        
        int index=0;
        Node node = header.nextNode;
        Object nodeData = node.data;
        
        // header에서 부터 순차적으로 nodeData와 값을 비교한다.
        while(!obj.equals(nodeData)){
            node = node.nextNode;
            
            if(node==null){
                return -1;
            }
            
            nodeData = node.data;
            index++;
        }
        
        return index;
    }
    
    // data를 리스트의 첫번째에 삽입한다.
    public void addFirst(String data){
        
        Node newNode = new Node(data);
        newNode.nextNode = header.nextNode;
        header.nextNode = newNode;
        size++;
        
    }
    
    // index 위치에 data를 삽입한다.
    public void add(int index, String data){
        
        if(index==0){
        	///수정
        	  Node newNode = new Node(data);
              newNode.nextNode = header.nextNode;
              header.nextNode = newNode;
              size++;
          //  return;
        }else{
        
        	Node previous = getNode(index-1);
        	Node next = previous.nextNode;
        
        	Node newNode = new Node(data);
        	previous.nextNode = newNode;
        	newNode.nextNode = next;
        	size++;
        }
    }
    
 
    
    // 리스트의 마지막에 data 를 삽입한다.
    public void addLast(String data){
        add(size, data);
    }
    
    // 리스트의 마지막에 data를 삽입한다.
    public void add(String data){
        addLast(data);
    }
    
    // 첫번째 노드를 제거하고 데이터를 반환한다.
    public Object removeFirst(){
        
        Node firstNode = getNode(0);
        header.nextNode = firstNode.nextNode;
        size--;
        return firstNode.data;
        
    }
    
    // index 위치의 노드를 제거하고 데이터를 반환한다.
    public Object remove(int index){
        
        if(index<0 || index>=size){
            
            throw new IndexOutOfBoundsException("Index : " + index + ", Size : " +size);
        
        }else if(index ==0){
            
            return removeFirst();
        
        }
        
        Node previous = getNode(index-1);
        Node removeNode = previous.nextNode;
        Node next = removeNode.nextNode;
        previous.nextNode = next;
        size--;
        
        return removeNode.data;
    }
    
    // 리스트에서 data를 가진 노드를 제거하고 제거여부를 반환한다.
    public boolean remove(String data){
        
        int nodeIndex = getNodeIndex(data);
        
        if(nodeIndex == -1){
            return false;
        }else{
            remove(nodeIndex);
            return true;
        }
    }
    
    // 리스트의 마지막 노드를 제거하고 데이터를 반환한다.
    public Object removeLast(){
        return remove(size-1);
    }
    
    // 리스트의 크기를 반환한다.
    public int size(){
        return size;
    }
    
    // 리스트의 데이터 String으로 반환
    public String toString(){
        
        StringBuffer result = new StringBuffer(" ");
        Node node = header.nextNode;
        
        if(node!=null){
            result.append(node.data);
            node = node.nextNode;
            
            while(node != null){
                result.append(", ");
                result.append(node.data);
                node = node.nextNode;
            }
        }
        
        result.append(" ");
        return result.toString();
    }

	
}
