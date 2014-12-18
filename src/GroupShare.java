import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;




public class GroupShare extends linkedGroup {
	public String Groups[][];
	public float capabilityAvg[];
	public int  divisor, share, remainder;
	public int groupColumn, groupRow;
    int front, rear;
    int randomArray[] ;
    int allRandomArray[] ;
    int randomCount =0;
    int tableAllcount;

    public void insertGroup(linkedGroup[] l_Teams, linkedGroup[] l_Capability){//1213(linkedGroup linkG, linkedGroup[] l_Teams){//String[][] teamArray ){
		Groups = new String[groupColumn][groupRow];
		capabilityAvg = new float[groupColumn];
		String capability[][] = new String[groupColumn][groupRow-1];
		
		char ch = 'A';
		
		for(int i=0; i<Groups.length; i++) {
			
			Character cr = new Character(ch);
			Groups[i][0] = cr.toString();
			
			ch++;
		}
		List<Integer> randomList = new ArrayList<>();
		randomList = createRandomArray(l_Teams);
		int n =0;
		int teamRandom = 0;
		for(int y=1; y<groupRow; y++) {
	     
	         for(int x=0; x<groupColumn; x++) {
		         //int teamRandom = random.nextInt(6);
	        	 
	        	 //������ index�� �����ִ°��̸����ϵ�/ �� linkedGroup���� �Լ����������Ѵ�.
	        	 /*if(linkG.getNodeIndex(l_Teams[teamRandom]) == -1 ){
	        		 
	        	 }*/
	        	 if(n < tableAllcount){
	        		// System.out.println(" random:"+teamRandom+ " group " + " x="+x +" y="+y + " n= " +n);
	        		 teamRandom = randomList.get(n);
		        	  
	        		 if(l_Teams[teamRandom].size() > 0){
	    	        	 n++; 
	    	        	 Groups[x][y] = l_Teams[teamRandom].get(0);//String �׻�0��° ������ �̱�
		        			capability[x][y-1] = l_Capability[teamRandom].get(0);
		        			//System.out.println("insert: "+ l_Teams[teamRandom].get(0) + " n= " + n);

		        			l_Teams[teamRandom].removeFirst();//ù��°�����
		        			l_Capability[teamRandom].removeFirst();
		        		}
		        	}
				}
			}
			
			int capabilitySum = 0;
			int h = 0;
			
			for(int w=0; w<groupColumn; w++) {
				
				for(h=0; h<groupRow-1; h++) {
					
					if(capability[w][h]!=null)
						capabilitySum += Integer.parseInt(capability[w][h]);
				}
				
				capabilityAvg[w] = Float.valueOf(String.format("%.2f", (float)capabilitySum/h));
				capabilitySum = 0;
			}
		}

	
	public List<Integer> createRandomArray(linkedGroup[] l_Teams){
		randomArray = new int[7];
		allRandomArray = new int[tableAllcount];
		randomCount=0;
		for(int i =0; i<7 ; i++){
			randomArray[i] = l_Teams[i].size(); //�� ���� ����� �־��ش�.
			//System.out.println("randomArray[i]=" + i + "�������� ="+ l_Teams[i].size() );
			for(int j=0 ; j < l_Teams[i].size() ; j++){
				//System.out.println("j "+j);
				allRandomArray[randomCount] = i;
				//System.out.println("allRandomArray[randomcount]=" + allRandomArray[randomCount] );
				randomCount ++;
			}
			
			
		}//for
		
		
		List<Integer> randomList = new ArrayList<>();
		for(int i=0; i< allRandomArray.length ; i++){
			randomList.add(allRandomArray[i]);
		}
		
		
		Collections.shuffle(randomList);
		
		return randomList;
	}
	
/*
	public boolean isEmpty(String object) {
        if (object == null) {
            return false;
        }
		return true;
    }
*/	
	
	
	public void setNumberOfGroup(int allCount) {
		tableAllcount = allCount;
		Random divisorRandom = new Random();
		
		divisor = divisorRandom.nextInt(4)+5;
		
		remainder = allCount % divisor; //������
		share = allCount / divisor; //��
		groupColumn = share ;
		
		if(remainder == 0) {
			//int groupColumn��, groupRow��;
			groupRow = divisor + 1;
		}
		else {
			groupRow = divisor + 2;
		}
	}
	
}
