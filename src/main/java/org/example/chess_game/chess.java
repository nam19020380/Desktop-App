package chess_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

class obj implements ActionListener{
	
	JFrame game_frame;
	String brown="#8A6A4F";
	String white="#FABB79";
	JLabel label;
	JButton c00,c01,c02,c03,c04,c05,c06,c07,c10,c11,c12,c13,c14,c15,c16,c17,c20,c21,c22,c23,c24,c25,c26,c27,c30,c31,c32,c33,c34,c35,c36,c37,c40,c41,c42,c43,c44,c45,c46,c47,c50,c51,c52,c53,c54,c55,c56,c57,c60,c61,c62,c63,c64,c65,c66,c67,c70,c71,c72,c73,c74,c75,c76,c77;
	static boolean en=false;
	LinkedList<String> count; 
	String[][] arr ;
	Map<String,JButton> bttn_map ;
	Map<String,String> pos_map ;
	String bp="265F";
	String br="265C";
	String bh="265E";
	String bn="265D";
	String bk="265A";
	String bq="265B";
	
	String white_label="Player White Turn "+String.valueOf(Character.toChars(Integer.parseInt(bh, 16)));
	String black_label="Player Black Turn "+String.valueOf(Character.toChars(Integer.parseInt(bh, 16)));
	
	Color w= Color.WHITE;
	Color b= Color.BLACK;
	char player_turn;
	
	Border border = BorderFactory.createLineBorder(Color.BLACK,2);
	
	obj(JFrame game_frame)
	{
		this.game_frame=game_frame;
		
		count =new LinkedList<String>(); 
		pos_map = new HashMap<String, String>();
		 bttn_map = new HashMap();
		create_tiles();	
		retrive();	
		
		arr = new String[][]{ { "br","bh","bn","bq","bk","bn","bh","br" }, 
		           { "bp","bp","bp","bp","bp","bp","bp","bp" },
		           { "--","--","--","--","--","--","--","--" },
		           { "--","--","--","--","--","--","--","--" },
		           { "--","--","--","--","--","--","--","--" },
		           { "--","--","--","--","--","--","--","--" },
		           { "wp","wp","wp","wp","wp","wp","wp","wp" },
		           { "wr","wh","wn","wq","wk","wn","wh","wr" }};

		player_turn='b';
		           
		label = new JLabel("Player Black Turn "+String.valueOf(Character.toChars(Integer.parseInt(bh, 16))));
		label.setBounds(730,330,700,70);
		label.setVisible(true);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Serif", Font.BOLD, 45));
		game_frame.add(label);
	}
	
	//intlise

	public void intlise()
	{
		label.setText(black_label);
		arr = new String[][]{ { "br","bh","bn","bq","bk","bn","bh","br" }, 
	           { "bp","bp","bp","bp","bp","bp","bp","bp" },
	           { "--","--","--","--","--","--","--","--" },
	           { "--","--","--","--","--","--","--","--" },
	           { "--","--","--","--","--","--","--","--" },
	           { "--","--","--","--","--","--","--","--" },
	           { "wp","wp","wp","wp","wp","wp","wp","wp" },
	           { "wr","wh","wn","wq","wk","wn","wh","wr" }};
	           
	     player_turn='b'; 
	     count =new LinkedList<String>(); 
			pos_map = new HashMap<String, String>();
			 bttn_map = new HashMap();
			pos_map.clear();
			bttn_map.clear();
			retrive();
		count.clear();
		
		c00.setText(String.valueOf(Character.toChars(Integer.parseInt(br, 16))));
		c01.setText(String.valueOf(Character.toChars(Integer.parseInt(bh, 16))));
		c02.setText(String.valueOf(Character.toChars(Integer.parseInt(bn, 16))));
		c03.setText(String.valueOf(Character.toChars(Integer.parseInt(bq, 16))));
		c04.setText(String.valueOf(Character.toChars(Integer.parseInt(bk, 16))));
		c05.setText(String.valueOf(Character.toChars(Integer.parseInt(bn, 16))));
		c06.setText(String.valueOf(Character.toChars(Integer.parseInt(bh, 16))));
		c07.setText(String.valueOf(Character.toChars(Integer.parseInt(br, 16))));
		c10.setText(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
		c11.setText(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
		c12.setText(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
		c13.setText(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
		c14.setText(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
		c15.setText(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
		c16.setText(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
		c17.setText(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
		c00.setForeground(Color.BLACK);
		c01.setForeground(Color.BLACK);
		c02.setForeground(Color.BLACK);
		c03.setForeground(Color.BLACK);
		c04.setForeground(Color.BLACK);
		c05.setForeground(Color.BLACK);
		c06.setForeground(Color.BLACK);
		c07.setForeground(Color.BLACK);
		c10.setForeground(Color.BLACK);
		c11.setForeground(Color.BLACK);
		c12.setForeground(Color.BLACK);
		c13.setForeground(Color.BLACK);
		c14.setForeground(Color.BLACK);
		c15.setForeground(Color.BLACK);
		c16.setForeground(Color.BLACK);
		c17.setForeground(Color.BLACK);

		
		c20.setText("");
		c21.setText("");
		c22.setText("");
		c23.setText("");
		c24.setText("");
		c25.setText("");
		c26.setText("");
		c27.setText("");
		c30.setText("");
		c31.setText("");
		c32.setText("");
		c33.setText("");
		c34.setText("");
		c35.setText("");
		c36.setText("");
		c37.setText("");
		c40.setText("");
		c41.setText("");
		c42.setText("");
		c43.setText("");
		c44.setText("");
		c45.setText("");
		c46.setText("");
		c47.setText("");
		c50.setText("");
		c51.setText("");
		c52.setText("");
		c53.setText("");
		c54.setText("");
		c55.setText("");
		c56.setText("");
		c57.setText("");
		
		
		c70.setText(String.valueOf(Character.toChars(Integer.parseInt(br, 16))));
		c71.setText(String.valueOf(Character.toChars(Integer.parseInt(bh, 16))));
		c72.setText(String.valueOf(Character.toChars(Integer.parseInt(bn, 16))));
		c73.setText(String.valueOf(Character.toChars(Integer.parseInt(bq, 16))));
		c74.setText(String.valueOf(Character.toChars(Integer.parseInt(bk, 16))));
		c75.setText(String.valueOf(Character.toChars(Integer.parseInt(bn, 16))));
		c76.setText(String.valueOf(Character.toChars(Integer.parseInt(bh, 16))));
		c77.setText(String.valueOf(Character.toChars(Integer.parseInt(br, 16))));
		c60.setText(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
		c61.setText(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
		c62.setText(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
		c63.setText(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
		c64.setText(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
		c65.setText(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
		c66.setText(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
		c67.setText(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
		c60.setForeground(Color.WHITE);
		c61.setForeground(Color.WHITE);
		c62.setForeground(Color.WHITE);
		c63.setForeground(Color.WHITE);
		c64.setForeground(Color.WHITE);
		c65.setForeground(Color.WHITE);
		c66.setForeground(Color.WHITE);
		c67.setForeground(Color.WHITE);
		c70.setForeground(Color.WHITE);
		c71.setForeground(Color.WHITE);
		c72.setForeground(Color.WHITE);
		c73.setForeground(Color.WHITE);
		c74.setForeground(Color.WHITE);
		c75.setForeground(Color.WHITE);
		c76.setForeground(Color.WHITE);
		c77.setForeground(Color.WHITE);
		

	}
	
	//intlise
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		System.out.println(e.getActionCommand());
		String pressed= e.getActionCommand();
		int xx=pressed.charAt(1)-48;
		int yy=pressed.charAt(2)-48;
		char this_turn=arr[xx][yy].charAt(0);
		
		if(!count.isEmpty())
		{
				
			String org = count.get(count.size()-1);
			int x1=org.charAt(1)-48;
			int y1=org.charAt(2)-48;
			String last_piece="";
			
//			System.out.println("work "+arr[x1][y1]+""+count);
			
			for(int i=0;i<count.size();i++)
			{
				String str=count.get(i);
				int x=str.charAt(1)-48;
				int y=str.charAt(2)-48;
				JButton prrsd=bttn_map.get(str);
				if((x+y)%2==0)
				prrsd.setBackground(Color.decode(brown));
				else
				prrsd.setBackground(Color.decode(white));	
				prrsd.setBorderPainted(false);
				
				if(pressed.equals(str) && count.size()-1!=i)
				{
					JButton sample=	bttn_map.get(org);
					String piece=sample.getText();
					last_piece=arr[x][y];
					sample.setText("");
					prrsd.setText(piece);
					pos_map.remove(org);
					pos_map.remove(str);
					piece=arr[x1][y1];
				
					arr[x1][y1]="--";
					arr[x][y]=piece;
					if(piece.equals("bp") || piece.equals("wp"))
					piece=piece+"f";
					pos_map.put(str, piece);
					if(piece.charAt(0)=='w')
					prrsd.setForeground(Color.white);
					else
					prrsd.setForeground(Color.black);
					
					if(player_turn=='b')
					{player_turn='w';
					label.setText(white_label);
					label.setForeground(Color.white);
					}
					else
					{player_turn='b';
					label.setText(black_label);
					label.setForeground(Color.black);
					};	
					
				}
			}
			
			if(last_piece.equals("bk") || last_piece.equals("wk"))
			{
				String s="Player Black Wins";
				if(player_turn=='b')
				s="Player White Wins";
					
				JOptionPane.showMessageDialog(game_frame,s);
				intlise();
			}
			
			for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
			if(!pos_map.containsKey("c"+i+""+j))
				{
					JButton sample = bttn_map.get("c"+i+""+j);
					sample.setEnabled(false);
				}
			
			count.clear(); 
			
			
			
			
			
			
		}
		
		else if(count.isEmpty() && this_turn == player_turn)
		{
		String str=e.getActionCommand();
		int x=str.charAt(1)-48;
		int y=str.charAt(2)-48;
		String pos=pos_map.get(str);
		char c= pos.charAt(1);
		
		if(c=='p')
		pawn(x,y,pos);
		else if(c=='r')
		rook(x,y,pos.charAt(0));
		else if (c=='h')
		horse(x,y,pos.charAt(0));
		else if(c=='q')
		queen(x,y,pos.charAt(0));
		else if(c=='n')
		bishop(x,y,pos.charAt(0));
		else if(c=='k')
		king(x,y,pos.charAt(0));	
		
		for(int i=0;i<count.size();i++)
		{
			String str_pos=count.get(i);
			JButton sample = bttn_map.get(str_pos);
			sample.setBackground(Color.decode("#a6ff4d"));
			sample.setBorderPainted(true);
			sample.setBorder(border);
			
			if(count.size()-1==i)
				{sample.setBackground(Color.decode("#3399ff"));}
			else if(pos_map.containsKey(count.get(i)))
					sample.setBackground(Color.decode("#ff5050"));	
			
		}
		
		for(int i=0;i<8;i++)
		for(int j=0;j<8;j++)
		{
			JButton sample = bttn_map.get("c"+i+""+j);
			sample.setEnabled(true);
		}
		
		
		
	}
	}
	
	
	//retrive 
	
	public void retrive()
	{
		bttn_map.put("c00",c00);
		bttn_map.put("c01",c01);
		bttn_map.put("c02",c02);
		bttn_map.put("c03",c03);
		bttn_map.put("c04",c04);
		bttn_map.put("c05",c05);
		bttn_map.put("c06",c06);
		bttn_map.put("c07",c07);
		bttn_map.put("c10",c10);
		bttn_map.put("c11",c11);
		bttn_map.put("c12",c12);
		bttn_map.put("c13",c13);
		bttn_map.put("c14",c14);
		bttn_map.put("c15",c15);
		bttn_map.put("c16",c16);
		bttn_map.put("c17",c17);
		bttn_map.put("c20",c20);
		bttn_map.put("c21",c21);
		bttn_map.put("c22",c22);
		bttn_map.put("c23",c23);
		bttn_map.put("c24",c24);
		bttn_map.put("c25",c25);
		bttn_map.put("c26",c26);
		bttn_map.put("c27",c27);
		bttn_map.put("c30",c30);
		bttn_map.put("c31",c31);
		bttn_map.put("c32",c32);
		bttn_map.put("c33",c33);
		bttn_map.put("c34",c34);
		bttn_map.put("c35",c35);
		bttn_map.put("c36",c36);
		bttn_map.put("c37",c37);
		bttn_map.put("c40",c40);
		bttn_map.put("c41",c41);
		bttn_map.put("c42",c42);
		bttn_map.put("c43",c43);
		bttn_map.put("c44",c44);
		bttn_map.put("c45",c45);
		bttn_map.put("c46",c46);
		bttn_map.put("c47",c47);
		bttn_map.put("c50",c50);
		bttn_map.put("c51",c51);
		bttn_map.put("c52",c52);
		bttn_map.put("c53",c53);
		bttn_map.put("c54",c54);
		bttn_map.put("c55",c55);
		bttn_map.put("c56",c56);
		bttn_map.put("c57",c57);
		bttn_map.put("c60",c60);
		bttn_map.put("c61",c61);
		bttn_map.put("c62",c62);
		bttn_map.put("c63",c63);
		bttn_map.put("c64",c64);
		bttn_map.put("c65",c65);
		bttn_map.put("c66",c66);
		bttn_map.put("c67",c67);
		bttn_map.put("c70",c70);
		bttn_map.put("c71",c71);
		bttn_map.put("c72",c72);
		bttn_map.put("c73",c73);
		bttn_map.put("c74",c74);
		bttn_map.put("c75",c75);
		bttn_map.put("c76",c76);
		bttn_map.put("c77",c77);
		
		pos_map.put("c00","br");
		pos_map.put("c01","bh");
		pos_map.put("c02","bn");
		pos_map.put("c03","bq");
		pos_map.put("c04","bk");
		pos_map.put("c05","bn");
		pos_map.put("c06","bh");
		pos_map.put("c07","br");
		pos_map.put("c10","bpt");
		pos_map.put("c11","bpt");
		pos_map.put("c12","bpt");
		pos_map.put("c13","bpt");
		pos_map.put("c14","bpt");
		pos_map.put("c15","bpt");
		pos_map.put("c16","bpt");
		pos_map.put("c17","bpt");
		
		pos_map.put("c70","wr");
		pos_map.put("c71","wh");
		pos_map.put("c72","wn");
		pos_map.put("c73","wq");
		pos_map.put("c74","wk");
		pos_map.put("c75","wn");
		pos_map.put("c76","wh");
		pos_map.put("c77","wr");
		pos_map.put("c60","wpt");
		pos_map.put("c61","wpt");
		pos_map.put("c62","wpt");
		pos_map.put("c63","wpt");
		pos_map.put("c64","wpt");
		pos_map.put("c65","wpt");
		pos_map.put("c66","wpt");
		pos_map.put("c67","wpt");
		
	}
	
	//retrive_end
	
	//pawn movement
	
	public void pawn(int x,int y , String str)
	{
		char c = str.charAt(0);
		count.push("c"+x+""+y);
		
		char ac;
	      if(c=='b')
	      ac='w';
	      else
	      ac='b'; 
		
	    if(c=='b')
	    {	
		if(x+1<8 && arr[x+1][y].charAt(0)!=c && arr[x+1][y].charAt(0)!=ac)
		{
			count.push("c"+(x+1)+""+(y));
			if(str.charAt(2)=='t' && x+2<8 && arr[x+2][y].charAt(0)!=c)
			count.push("c"+(x+2)+""+(y));
		}
		
		if(x+1<8 && y+1<8 && arr[x+1][y+1].charAt(0)==ac)
		count.push("c"+(x+1)+""+(y+1));
		if(x+1<8 && y-1>=0 && arr[x+1][y-1].charAt(0)==ac)
		count.push("c"+(x+1)+""+(y-1));
			
	    }
	    
	    else
	    {	
			if(x-1>=0 && arr[x-1][y].charAt(0)!=c && arr[x-1][y].charAt(0)!=ac)
			{
				count.push("c"+(x-1)+""+(y));
				if(str.charAt(2)=='t' && x-2>=0 && arr[x-2][y].charAt(0)!=c)
				count.push("c"+(x-2)+""+(y));
			}
			
			if(x-1>=0 && y-1>=0 && arr[x-1][y-1].charAt(0)==ac)
			count.push("c"+(x-1)+""+(y-1));	
			if(x-1>=0 && y+1<8 && arr[x-1][y+1].charAt(0)==ac)
			count.push("c"+(x-1)+""+(y+1));
			
			
		    }	
		
	}
	//pawn movement
	
	// horse movement
	
	public void horse(int x,int y,char c)
	{
			count.push("c"+x+""+y);
		
			if(x-2>=0 && y-1>=0 && arr[x-2][y-1].charAt(0)!=c)
		    count.push("c"+(x-2)+""+(y-1));
			if(x-1>=0 &&  y-2>=0 && arr[x-1][y-2].charAt(0)!=c)
			count.push("c"+(x-1)+""+(y-2));
			if(x+2<8  && y-1>=0 && arr[x+2][y-1].charAt(0)!=c)
			count.push("c"+(x+2)+""+(y-1));
			if(x+1<8  && y-2>=0 && arr[x+1][y-2].charAt(0)!=c)
			count.push("c"+(x+1)+""+(y-2));
			if(x-2>=0  && y+1<8 && arr[x-2][y+1].charAt(0)!=c)
			count.push("c"+(x-2)+""+(y+1));
			if(x-1>=0  && y+2<8 && arr[x-1][y+2].charAt(0)!=c)
			count.push("c"+(x-1)+""+(y+2));
			if(x+1<8  && y+2<8 && arr[x+1][y+2].charAt(0)!=c)
			count.push("c"+(x+1)+""+(y+2));
			if(x+2<8  && y+1<8 && arr[x+2][y+1].charAt(0)!=c)
			count.push("c"+(x+2)+""+(y+1));
	}
	
	//horse movement
	
	//bishop movement
	
	public void bishop(int x,int y,char c)
	{
		  int i=x-1;
	      int j=y-1;
	      count.push("c"+x+""+y);
	      
	      char ac;
	      if(c=='b')
	      ac='w';
	      else
	      ac='b';  
	            
	      while(i>=0 && j>=0 && arr[i][j].charAt(0)!=c)
	      {count.push("c"+i+""+j);
	      if(arr[i][j].charAt(0)==ac)
	      break;  
	      i--;j--;}
	      i=x+1;j=y+1;
	      while(i<8 && j<8 && arr[i][j].charAt(0)!=c)
	      {count.push("c"+i+""+j);
	      if(arr[i][j].charAt(0)==ac)
	      break;  
	      i++;j++;}
	      i=x-1;j=y+1;
	      while(i>=0 && j<8 && arr[i][j].charAt(0)!=c)
	      {count.push("c"+i+""+j);
	      if(arr[i][j].charAt(0)==ac)
	      break;  
	      i--;j++;}
	      i=x+1;j=y-1;
	      while(i<8 && j>=0 && arr[i][j].charAt(0)!=c)
	      {count.push("c"+i+""+j);
	      if(arr[i][j].charAt(0)==ac)
	      break;  
	      i++;j--;}
		
	}
	//bishop movement end 
	
	//rook movement
	
	public void rook(int x,int y,char c)
	{
		int i=x-1;
	      int j=y;
	      count.push("c"+x+""+y);
	      
	      char ac;
	      if(x=='b')
	      ac='w';
	      else
	      ac='b';
	      
	      while(i>=0 && arr[i][j].charAt(0)!=c)
	      {count.push("c"+i+""+j);
	      if(arr[i][j].charAt(0)==ac)
	      break;  
	      i--;}
	      i=x+1;j=y;
	      while(i<8 && arr[i][j].charAt(0)!=c)
	      {count.push("c"+i+""+j);
	      if(arr[i][j].charAt(0)==ac)
	      break;  
	      i++;}
	      i=x;j=y+1;
	      while(j<8 && arr[i][j].charAt(0)!=c)
	      {count.push("c"+i+""+j);
	      if(arr[i][j].charAt(0)==ac)
	      break;  
	      j++;}
	      i=x;j=y-1;
	      while(j>=0 && arr[i][j].charAt(0)!=c)
	      {count.push("c"+i+""+j);
	      if(arr[i][j].charAt(0)==ac)
	      break;  
	      j--;}
	}
	
	//rook movement end
	
	//queen movement 
	
	public void queen(int x,int y,char c)
	{
		int i=x-1;
	      int j=y;
	      count.push("c"+x+""+y);
	      
	      char ac;
	      if(x=='b')
	      ac='w';
	      else
	      ac='b';
	      
	      while(i>=0 && arr[i][j].charAt(0)!=c)
	      {count.push("c"+i+""+j);
	      if(arr[i][j].charAt(0)==ac)
	      break;  
	      i--;}
	      i=x+1;j=y;
	      while(i<8 && arr[i][j].charAt(0)!=c)
	      {count.push("c"+i+""+j);
	      if(arr[i][j].charAt(0)==ac)
	      break;  
	      i++;}
	      i=x;j=y+1;
	      while(j<8 && arr[i][j].charAt(0)!=c)
	      {count.push("c"+i+""+j);
	      if(arr[i][j].charAt(0)==ac)
	      break;  
	      j++;}
	      i=x;j=y-1;
	      while(j>=0 && arr[i][j].charAt(0)!=c)
	      {count.push("c"+i+""+j);
	      if(arr[i][j].charAt(0)==ac)
	      break;  
	      j--;}
	      i=x-1;j=y-1;
	      while(i>=0 && j>=0 && arr[i][j].charAt(0)!=c)
	      {count.push("c"+i+""+j);
	      if(arr[i][j].charAt(0)==ac)
	      break;  
	      i--;j--;}
	      i=x+1;j=y+1;
	      while(i<8 && j<8 && arr[i][j].charAt(0)!=c)
	      {count.push("c"+i+""+j);
	      if(arr[i][j].charAt(0)==ac)
	      break;  
	      i++;j++;}
	      i=x-1;j=y+1;
	      while(i>=0 && j<8 && arr[i][j].charAt(0)!=c)
	      {count.push("c"+i+""+j);
	      if(arr[i][j].charAt(0)==ac)
	      break;  
	      i--;j++;}
	      i=x+1;j=y-1;
	      while(i<8 && j>=0 && arr[i][j].charAt(0)!=c)
	      {count.push("c"+i+""+j);
	      if(arr[i][j].charAt(0)==ac)
	      break;  
	      i++;j--;}
		
	}
	
	//queen movement end
	
	//king movement
	
	public void king(int x,int y,char c)
	{
		int i=x;
		int j=y;
	
		count.push("c"+x+""+y);
		if(x-1>=0 && arr[x-1][j].charAt(0)!=c)
		count.push("c"+(x-1)+""+y);	
		if(y-1>=0 && arr[i][j-1].charAt(0)!=c)
		count.push("c"+(x)+""+(y-1));	
		if(x+1<8 && arr[i+1][j].charAt(0)!=c)
		count.push("c"+(x+1)+""+(y));	
		if(y+1<8 && arr[i][j+1].charAt(0)!=c)
		count.push("c"+(x)+""+(y+1));	;
		if(x-1>=0 && y-1>=0 && arr[i-1][j-1].charAt(0)!=c)
		count.push("c"+(x-1)+""+(y-1));	
		if(x+1<8 && y+1<8 && arr[i+1][j+1].charAt(0)!=c)
		count.push("c"+(x+1)+""+(y+1));	
		if(x-1>=0 && y+1<8 && arr[i-1][j+1].charAt(0)!=c)
		count.push("c"+(x-1)+""+(y+1));	
		if(x+1<8 && y-1>=0 && arr[i+1][j-1].charAt(0)!=c)
		count.push("c"+(x+1)+""+(y-1));		
	}
	
	//king movement end
		
	//create tile
	
	public void create_tiles()
	{
		c00 = new JButton(String.valueOf(Character.toChars(Integer.parseInt(br, 16))));
		c00.setBounds(40,40,80,80);
		c00.setBackground(Color.decode(brown));
		c00.setActionCommand("c00");
		game_frame.add(c00);
		c00.addActionListener(this);
		c00.setBorderPainted(false);
		c00.setEnabled(true);
		
		c01 = new JButton(String.valueOf(Character.toChars(Integer.parseInt(bh, 16))));
		c01.setBounds(120,40,80,80);
		c01.setBackground(Color.decode(white));
		c01.setActionCommand("c01");
		game_frame.add(c01);
		c01.addActionListener(this);
		c01.setBorderPainted(false);
		c01.setEnabled(true);
		
		c02 = new JButton(String.valueOf(Character.toChars(Integer.parseInt(bn, 16))));
		c02.setBounds(200,40,80,80);
		c02.setBackground(Color.decode(brown));
		c02.setActionCommand("c02");
		game_frame.add(c02);
		c02.addActionListener(this);
		c02.setBorderPainted(false);
		c02.setEnabled(true);
		
		c03 = new JButton(String.valueOf(Character.toChars(Integer.parseInt(bq, 16))));
		c03.setBounds(280,40,80,80);
		c03.setBackground(Color.decode(white));
		c03.setActionCommand("c03");
		game_frame.add(c03);
		c03.addActionListener(this);
		c03.setBorderPainted(false);
		c03.setEnabled(true);
		
		c04 = new JButton(String.valueOf(Character.toChars(Integer.parseInt(bk, 16))));
		c04.setBounds(360,40,80,80);
		c04.setBackground(Color.decode(brown));
		c04.setActionCommand("c04");
		game_frame.add(c04);
		c04.addActionListener(this);
		c04.setBorderPainted(false);
		c04.setEnabled(true);
		
		c05 = new JButton(String.valueOf(Character.toChars(Integer.parseInt(bn, 16))));
		c05.setBounds(440,40,80,80);
		c05.setBackground(Color.decode(white));
		c05.setActionCommand("c05");
		game_frame.add(c05);
		c05.addActionListener(this);
		c05.setBorderPainted(false);
		c05.setEnabled(true);
		
		c06 = new JButton(String.valueOf(Character.toChars(Integer.parseInt(bh, 16))));
		c06.setBounds(520,40,80,80);
		c06.setBackground(Color.decode(brown));
		c06.setActionCommand("c06");
		game_frame.add(c06);
		c06.addActionListener(this);
		c06.setBorderPainted(false);
		c06.setEnabled(true);
		
		c07 = new JButton(String.valueOf(Character.toChars(Integer.parseInt(br, 16))));
		c07.setBounds(600,40,80,80);
		c07.setBackground(Color.decode(white));
		c07.setActionCommand("c07");
		game_frame.add(c07);
		c07.addActionListener(this);
		c07.setBorderPainted(false);
		c07.setEnabled(true);
		
		c10 = new JButton(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
		c10.setBounds(40,120,80,80);
		c10.setBackground(Color.decode(white));
		c10.setActionCommand("c10");
		game_frame.add(c10);
		c10.addActionListener(this);
		c10.setBorderPainted(false);
		c10.setEnabled(true);
		
		c11 = new JButton(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
		c11.setBounds(120,120,80,80);
		c11.setBackground(Color.decode(brown));
		c11.setActionCommand("c11");
		game_frame.add(c11);
		c11.addActionListener(this);
		c11.setBorderPainted(false);
		c11.setEnabled(true);
		
		c12 = new JButton(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
		c12.setBounds(200,120,80,80);
		c12.setBackground(Color.decode(white));
		c12.setActionCommand("c12");
		game_frame.add(c12);
		c12.addActionListener(this);
		c12.setBorderPainted(false);
		c12.setEnabled(true);
		
		c13 = new JButton(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
		c13.setBounds(280,120,80,80);
		c13.setBackground(Color.decode(brown));
		c13.setActionCommand("c13");
		game_frame.add(c13);
		c13.addActionListener(this);
		c13.setBorderPainted(false);
		c13.setEnabled(true);
		
		c14 = new JButton(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
		c14.setBounds(360,120,80,80);
		c14.setBackground(Color.decode(white));
		c14.setActionCommand("c14");
		game_frame.add(c14);
		c14.addActionListener(this);
		c14.setBorderPainted(false);
		c14.setEnabled(true);
		
		c15 = new JButton(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
		c15.setBounds(440,120,80,80);
		c15.setBackground(Color.decode(brown));
		c15.setActionCommand("c15");
		game_frame.add(c15);
		c15.addActionListener(this);
		c15.setBorderPainted(false);
		c15.setEnabled(true);
		
		c16 = new JButton(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
		c16.setBounds(520,120,80,80);
		c16.setBackground(Color.decode(white));
		c16.setActionCommand("c16");
		game_frame.add(c16);
		c16.addActionListener(this);
		c16.setBorderPainted(false);
		c16.setEnabled(true);
		
		c17 = new JButton(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
		c17.setBounds(600,120,80,80);
		c17.setBackground(Color.decode(brown));
		c17.setActionCommand("c17");
		game_frame.add(c17);
		c17.addActionListener(this);
		c17.setBorderPainted(false);
		c17.setEnabled(true);
		
		c20 = new JButton();
		c20.setBounds(40,200,80,80);
		c20.setBackground(Color.decode(brown));
		c20.setActionCommand("c20");
		game_frame.add(c20);
		c20.addActionListener(this);
		c20.setBorderPainted(false);
		c20.setEnabled(en);
		
		c21 = new JButton();
		c21.setBounds(120,200,80,80);
		c21.setBackground(Color.decode(white));
		c21.setActionCommand("c21");
		game_frame.add(c21);
		c21.addActionListener(this);
		c21.setBorderPainted(false);
		c21.setEnabled(en);
		
		c22 = new JButton();
		c22.setBounds(200,200,80,80);
		c22.setBackground(Color.decode(brown));
		c22.setActionCommand("c22");
		game_frame.add(c22);
		c22.addActionListener(this);
		c22.setBorderPainted(false);
		c22.setEnabled(en);
		
		c23 = new JButton();
		c23.setBounds(280,200,80,80);
		c23.setBackground(Color.decode(white));
		c23.setActionCommand("c23");
		game_frame.add(c23);
		c23.addActionListener(this);
		c23.setBorderPainted(false);
		c23.setEnabled(en);
		
		c24 = new JButton();
		c24.setBounds(360,200,80,80);
		c24.setBackground(Color.decode(brown));
		c24.setActionCommand("c24");
		game_frame.add(c24);
		c24.addActionListener(this);
		c24.setBorderPainted(false);
		c24.setEnabled(en);
		
		c25 = new JButton();
		c25.setBounds(440,200,80,80);
		c25.setBackground(Color.decode(white));
		c25.setActionCommand("c25");
		game_frame.add(c25);
		c25.addActionListener(this);
		c25.setBorderPainted(false);
		c25.setEnabled(en);
		
		c26 = new JButton();
		c26.setBounds(520,200,80,80);
		c26.setBackground(Color.decode(brown));
		c26.setActionCommand("c26");
		game_frame.add(c26);
		c26.addActionListener(this);
		c26.setBorderPainted(false);
		c26.setEnabled(en);
		
		c27 = new JButton();
		c27.setBounds(600,200,80,80);
		c27.setBackground(Color.decode(white));
		c27.setActionCommand("c27");
		game_frame.add(c27);
		c27.addActionListener(this);
		c27.setBorderPainted(false);
		c27.setEnabled(en);
		
		c30 = new JButton();
		c30.setBounds(40,280,80,80);
		c30.setBackground(Color.decode(white));
		c30.setActionCommand("c30");
		game_frame.add(c30);
		c30.addActionListener(this);
		c30.setBorderPainted(false);
		c30.setEnabled(en);
		
		c31 = new JButton();
		c31.setBounds(120,280,80,80);
		c31.setBackground(Color.decode(brown));
		c31.setActionCommand("c31");
		game_frame.add(c31);
		c31.addActionListener(this);
		c31.setBorderPainted(false);
		c31.setEnabled(en);
		
		c32 = new JButton();
		c32.setBounds(200,280,80,80);
		c32.setBackground(Color.RED);
		c32.setBackground(Color.decode(white));
		c32.setActionCommand("c32");
		game_frame.add(c32);
		c32.addActionListener(this);
		c32.setBorderPainted(false);
		c32.setEnabled(en);
		
		c33 = new JButton();
		c33.setBounds(280,280,80,80);
		c33.setBackground(Color.decode(brown));
		c33.setActionCommand("c33");
		game_frame.add(c33);
		c33.addActionListener(this);
		c33.setBorderPainted(false);
		c33.setEnabled(en);
		
		c34 = new JButton();
		c34.setBounds(360,280,80,80);
		c34.setBackground(Color.decode(white));
		c34.setActionCommand("c34");
		game_frame.add(c34);
		c34.addActionListener(this);
		c34.setBorderPainted(false);
		c34.setEnabled(en);
		
		c35 = new JButton();
		c35.setBounds(440,280,80,80);
		c35.setBackground(Color.decode(brown));
		c35.setActionCommand("c35");
		game_frame.add(c35);
		c35.addActionListener(this);
		c35.setBorderPainted(false);
		c35.setEnabled(en);
		
		c36 = new JButton();
		c36.setBounds(520,280,80,80);
		c36.setBackground(Color.decode(white));
		c36.setActionCommand("c36");
		game_frame.add(c36);
		c36.addActionListener(this);
		c36.setBorderPainted(false);
		c36.setEnabled(en);
		
		c37 = new JButton();
		c37.setBounds(600,280,80,80);
		c37.setBackground(Color.decode(brown));
		c37.setActionCommand("c37");
		game_frame.add(c37);
		c37.addActionListener(this);
		c37.setBorderPainted(false);
		c37.setEnabled(en);
		
		c40 = new JButton();
		c40.setBounds(40,360,80,80);
		c40.setBackground(Color.decode(brown));
		c40.setForeground(Color.WHITE);
		c40.setActionCommand("c40");
		game_frame.add(c40);
		c40.addActionListener(this);
		c40.setBorderPainted(false);
		c40.setEnabled(en);
		
		c41 = new JButton();
		c41.setBounds(120,360,80,80);
		c41.setBackground(Color.decode(white));
		c41.setActionCommand("c41");
		game_frame.add(c41);
		c41.addActionListener(this);
		c41.setBorderPainted(false);
		c41.setEnabled(en);
		
		c42 = new JButton();
		c42.setBounds(200, 360,80,80);
		c42.setBackground(Color.decode(brown));
		c42.setActionCommand("c42");
		game_frame.add(c42);
		c42.addActionListener(this);
		c42.setBorderPainted(false);
		c42.setEnabled(en);
		
		c43 = new JButton();
		c43.setBounds(280, 360,80,80);
		c43.setBackground(Color.RED);
		c43.setBackground(Color.decode(white));
		c43.setActionCommand("c43");
		game_frame.add(c43);
		c43.addActionListener(this);
		c43.setBorderPainted(false);
		c43.setEnabled(en);
		
		c44 = new JButton();
		c44.setBounds(360,360,80,80);
		c44.setBackground(Color.decode(brown));
		c44.setActionCommand("c44");
		game_frame.add(c44);
		c44.addActionListener(this);
		c44.setBorderPainted(false);
		c44.setEnabled(en);
		
		c45 = new JButton();
		c45.setBounds(440,360,80,80);
		c45.setBackground(Color.decode(white));
		c45.setActionCommand("c45");
		game_frame.add(c45);
		c45.addActionListener(this);
		c45.setBorderPainted(false);
		c45.setEnabled(en);
		
		c46 = new JButton();
		c46.setBounds(520,360,80,80);
		c46.setBackground(Color.decode(brown));
		c46.setActionCommand("c46");
		game_frame.add(c46);
		c46.addActionListener(this);
		c46.setBorderPainted(false);
		c46.setEnabled(en);
		
		c47 = new JButton();
		c47.setBounds(600,360,80,80);
		c47.setBackground(Color.decode(white));
		c47.setActionCommand("c47");
		game_frame.add(c47);
		c47.addActionListener(this);
		c47.setBorderPainted(false);
		c47.setEnabled(en);
		
		c50 = new JButton();
		c50.setBounds(40,440,80,80);
		c50.setBackground(Color.decode(white));
		c50.setForeground(Color.WHITE);
		c50.setActionCommand("c50");
		game_frame.add(c50);
		c50.addActionListener(this);
		c50.setBorderPainted(false);
		c50.setEnabled(en);
		
		c51 = new JButton();
		c51.setBounds(120,440,80,80);
		c51.setBackground(Color.decode(brown));
		c51.setActionCommand("c51");
		game_frame.add(c51);
		c51.addActionListener(this);
		c51.setBorderPainted(false);
		c51.setEnabled(en);
		
		c52 = new JButton();
		c52.setBounds(200, 440,80,80);
		c52.setBackground(Color.RED);
		c52.setBackground(Color.decode(white));
		c52.setActionCommand("c52");
		game_frame.add(c52);
		c52.addActionListener(this);
		c52.setBorderPainted(false);
		c52.setEnabled(en);
		
		c53 = new JButton();
		c53.setBounds(280, 440,80,80);
		c53.setBackground(Color.RED);
		c53.setBackground(Color.decode(brown));
		c53.setActionCommand("c53");
		game_frame.add(c53);
		c53.addActionListener(this);
		c53.setBorderPainted(false);
		c53.setEnabled(en);
		
		c54 = new JButton();
		c54.setBounds(360,440,80,80);
		c54.setBackground(Color.decode(white));
		c54.setActionCommand("c54");
		game_frame.add(c54);
		c54.addActionListener(this);
		c54.setBorderPainted(false);
		c54.setEnabled(en);
		
		c55 = new JButton();
		c55.setBounds(440,440,80,80);
		c55.setBackground(Color.decode(brown));
		c55.setActionCommand("c55");
		game_frame.add(c55);
		c55.addActionListener(this);
		c55.setBorderPainted(false);
		c55.setEnabled(en);
		
		c56 = new JButton();
		c56.setBounds(520,440,80,80);
		c56.setBackground(Color.decode(white));
		c56.setActionCommand("c56");
		game_frame.add(c56);
		c56.addActionListener(this);
		c56.setBorderPainted(false);
		c56.setEnabled(en);
		
		c57 = new JButton();
		c57.setBounds(600,440,80,80);
		c57.setBackground(Color.decode(brown));
		c57.setActionCommand("c57");
		game_frame.add(c57);
		c57.addActionListener(this);
		c57.setBorderPainted(false);
		c57.setEnabled(en);
		
		c60 = new JButton(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
		c60.setBounds(40,520,80,80);
		c60.setBackground(Color.decode(brown));
		c60.setActionCommand("c60");
		game_frame.add(c60);
		c60.addActionListener(this);
		c60.setBorderPainted(false);
		c60.setEnabled(true);
		
		c61 = new JButton(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
		c61.setBounds(120,520,80,80);
		c61.setBackground(Color.decode(white));
		c61.setActionCommand("c61");
		game_frame.add(c61);
		c61.addActionListener(this);
		c61.setBorderPainted(false);
		c61.setEnabled(true);
		
		c62 = new JButton(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
		c62.setBounds(200, 520,80,80);
		c62.setBackground(Color.decode(brown));
		c62.setActionCommand("c62");
		game_frame.add(c62);
		c62.addActionListener(this);
		c62.setBorderPainted(false);
		c62.setEnabled(true);
		
		c63 = new JButton(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
		c63.setBounds(280, 520,80,80);
		c63.setBackground(Color.decode(white));
		c63.setActionCommand("c63");
		game_frame.add(c63);
		c63.addActionListener(this);
		c63.setBorderPainted(false);
		c63.setEnabled(true);
		
		c64 = new JButton(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
		c64.setBounds(360,520,80,80);
		c64.setBackground(Color.decode(brown));
		c64.setActionCommand("c64");
		game_frame.add(c64);
		c64.addActionListener(this);
		c64.setBorderPainted(false);
		c64.setEnabled(true);
		
		c65 = new JButton(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
		c65.setBounds(440,520,80,80);
		c65.setBackground(Color.decode(white));
		c65.setActionCommand("c65");
		game_frame.add(c65);
		c65.addActionListener(this);
		c65.setBorderPainted(false);
		c65.setEnabled(true);
		
		c66 = new JButton(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
		c66.setBounds(520,520,80,80);
		c66.setBackground(Color.decode(brown));
		c66.setActionCommand("c66");
		game_frame.add(c66);
		c66.addActionListener(this);
		c66.setBorderPainted(false);
		c66.setEnabled(true);
		
		c67 = new JButton(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
		c67.setBounds(600,520,80,80);
		c67.setBackground(Color.decode(white));
		c67.setActionCommand("c67");
		game_frame.add(c67);
		c67.addActionListener(this);
		c67.setBorderPainted(false);
		c67.setEnabled(true);
		
		c70 = new JButton(String.valueOf(Character.toChars(Integer.parseInt(br, 16))));
		c70.setBounds(40,600,80,80);
		c70.setBackground(Color.decode(white));
		c70.setActionCommand("c70");
		game_frame.add(c70);
		c70.addActionListener(this);
		c70.setBorderPainted(false);
		c70.setEnabled(true);
		
		c71 = new JButton(String.valueOf(Character.toChars(Integer.parseInt(bh, 16))));
		c71.setBounds(120,600,80,80);
		c71.setBackground(Color.decode(brown));
		c71.setActionCommand("c71");
		game_frame.add(c71);
		c71.addActionListener(this);
		c71.setBorderPainted(false);
		c71.setEnabled(true);
		
		c72 = new JButton(String.valueOf(Character.toChars(Integer.parseInt(bn, 16))));
		c72.setBounds(200, 600,80,80);
		c72.setBackground(Color.RED);
		c72.setBackground(Color.decode(white));
		c72.setActionCommand("c72");
		game_frame.add(c72);
		c72.addActionListener(this);
		c72.setBorderPainted(false);
		c72.setEnabled(true);
		
		c73 = new JButton(String.valueOf(Character.toChars(Integer.parseInt(bq, 16))));
		c73.setBounds(280, 600,80,80);
		c73.setBackground(Color.decode(brown));
		c73.setActionCommand("c73");
		game_frame.add(c73);
		c73.addActionListener(this);
		c73.setBorderPainted(false);
		c73.setEnabled(true);
		
		c74 = new JButton(String.valueOf(Character.toChars(Integer.parseInt(bk, 16))));
		c74.setBounds(360,600,80,80);
		c74.setBackground(Color.decode(white));
		c74.setActionCommand("c74");
		game_frame.add(c74);
		c74.addActionListener(this);
		c74.setBorderPainted(false);
		c74.setEnabled(true);
		
		c75 = new JButton(String.valueOf(Character.toChars(Integer.parseInt(bn, 16))));
		c75.setBounds(440,600,80,80);
		c75.setBackground(Color.decode(brown));
		c75.setActionCommand("c75");
		game_frame.add(c75);
		c75.addActionListener(this);
		c75.setBorderPainted(false);
		c75.setEnabled(true);
		
		c76 = new JButton(String.valueOf(Character.toChars(Integer.parseInt(bh, 16))));
		c76.setBounds(520,600,80,80);
		c76.setBackground(Color.decode(white));
		c76.setActionCommand("c76");
		game_frame.add(c76);
		c76.addActionListener(this);
		c76.setBorderPainted(false);
		c76.setEnabled(true);
		
		c77 = new JButton(String.valueOf(Character.toChars(Integer.parseInt(br, 16))));
		c77.setBounds(600,600,80,80);
		c77.setBackground(Color.decode(brown));
		c77.setActionCommand("c77");
		game_frame.add(c77);
		c77.addActionListener(this);
		c77.setBorderPainted(false);
		c77.setEnabled(true);
		
		c00.setFont(new Font("Dialog", Font.BOLD, 40));
		c01.setFont(new Font("Dialog", Font.BOLD, 40));
		c02.setFont(new Font("Dialog", Font.BOLD, 40));
		c03.setFont(new Font("Dialog", Font.BOLD, 40));
		c04.setFont(new Font("Dialog", Font.BOLD, 40));
		c05.setFont(new Font("Dialog", Font.BOLD, 40));
		c06.setFont(new Font("Dialog", Font.BOLD, 40));
		c07.setFont(new Font("Dialog", Font.BOLD, 40));
		c10.setFont(new Font("Dialog", Font.BOLD, 40));
		c11.setFont(new Font("Dialog", Font.BOLD, 40));
		c12.setFont(new Font("Dialog", Font.BOLD, 40));
		c13.setFont(new Font("Dialog", Font.BOLD, 40));
		c14.setFont(new Font("Dialog", Font.BOLD, 40));
		c15.setFont(new Font("Dialog", Font.BOLD, 40));
		c16.setFont(new Font("Dialog", Font.BOLD, 40));
		c17.setFont(new Font("Dialog", Font.BOLD, 40));
		c20.setFont(new Font("Dialog", Font.BOLD, 40));
		c21.setFont(new Font("Dialog", Font.BOLD, 40));
		c22.setFont(new Font("Dialog", Font.BOLD, 40));
		c23.setFont(new Font("Dialog", Font.BOLD, 40));
		c24.setFont(new Font("Dialog", Font.BOLD, 40));
		c25.setFont(new Font("Dialog", Font.BOLD, 40));
		c26.setFont(new Font("Dialog", Font.BOLD, 40));
		c27.setFont(new Font("Dialog", Font.BOLD, 40));
		c30.setFont(new Font("Dialog", Font.BOLD, 40));
		c31.setFont(new Font("Dialog", Font.BOLD, 40));
		c32.setFont(new Font("Dialog", Font.BOLD, 40));
		c33.setFont(new Font("Dialog", Font.BOLD, 40));
		c34.setFont(new Font("Dialog", Font.BOLD, 40));
		c35.setFont(new Font("Dialog", Font.BOLD, 40));
		c36.setFont(new Font("Dialog", Font.BOLD, 40));
		c37.setFont(new Font("Dialog", Font.BOLD, 40));
		c40.setFont(new Font("Dialog", Font.BOLD, 40));
		c41.setFont(new Font("Dialog", Font.BOLD, 40));
		c42.setFont(new Font("Dialog", Font.BOLD, 40));
		c43.setFont(new Font("Dialog", Font.BOLD, 40));
		c44.setFont(new Font("Dialog", Font.BOLD, 40));
		c45.setFont(new Font("Dialog", Font.BOLD, 40));
		c46.setFont(new Font("Dialog", Font.BOLD, 45));
		c47.setFont(new Font("Dialog", Font.BOLD, 40));
		c50.setFont(new Font("Dialog", Font.BOLD, 40));
		c51.setFont(new Font("Dialog", Font.BOLD, 40));
		c52.setFont(new Font("Dialog", Font.BOLD, 40));
		c53.setFont(new Font("Dialog", Font.BOLD, 40));
		c54.setFont(new Font("Dialog", Font.BOLD, 40));
		c55.setFont(new Font("Dialog", Font.BOLD, 40));
		c56.setFont(new Font("Dialog", Font.BOLD, 40));
		c57.setFont(new Font("Dialog", Font.BOLD, 40));
		c60.setFont(new Font("Dialog", Font.BOLD, 40));
		c61.setFont(new Font("Dialog", Font.BOLD, 40));
		c62.setFont(new Font("Dialog", Font.BOLD, 40));
		c63.setFont(new Font("Dialog", Font.BOLD, 40));
		c64.setFont(new Font("Dialog", Font.BOLD, 40));
		c65.setFont(new Font("Dialog", Font.BOLD, 40));
		c66.setFont(new Font("Dialog", Font.BOLD, 40));
		c67.setFont(new Font("Dialog", Font.BOLD, 40));
		c70.setFont(new Font("Dialog", Font.BOLD, 40));
		c71.setFont(new Font("Dialog", Font.BOLD, 40));
		c72.setFont(new Font("Dialog", Font.BOLD, 40));
		c73.setFont(new Font("Dialog", Font.BOLD, 40));
		c74.setFont(new Font("Dialog", Font.BOLD, 40));
		c75.setFont(new Font("Dialog", Font.BOLD, 40));
		c76.setFont(new Font("Dialog", Font.BOLD, 40));
		c77.setFont(new Font("Dialog", Font.BOLD, 40));
		c00.setFocusPainted(false); 
		c01.setFocusPainted(false); 
		c02.setFocusPainted(false); 
		c03.setFocusPainted(false); 
		c04.setFocusPainted(false); 
		c05.setFocusPainted(false); 
		c06.setFocusPainted(false); 
		c07.setFocusPainted(false); 
		c10.setFocusPainted(false); 
		c11.setFocusPainted(false); 
		c12.setFocusPainted(false); 
		c13.setFocusPainted(false); 
		c14.setFocusPainted(false); 
		c15.setFocusPainted(false); 
		c16.setFocusPainted(false); 
		c17.setFocusPainted(false); 
		c20.setFocusPainted(false); 
		c21.setFocusPainted(false); 
		c22.setFocusPainted(false); 
		c23.setFocusPainted(false); 
		c24.setFocusPainted(false); 
		c25.setFocusPainted(false); 
		c26.setFocusPainted(false); 
		c27.setFocusPainted(false); 
		c30.setFocusPainted(false); 
		c31.setFocusPainted(false); 
		c32.setFocusPainted(false); 
		c33.setFocusPainted(false); 
		c34.setFocusPainted(false); 
		c35.setFocusPainted(false); 
		c36.setFocusPainted(false); 
		c37.setFocusPainted(false); 
		c40.setFocusPainted(false); 
		c41.setFocusPainted(false); 
		c42.setFocusPainted(false); 
		c43.setFocusPainted(false); 
		c44.setFocusPainted(false); 
		c45.setFocusPainted(false); 
		c46.setFocusPainted(false); 
		c47.setFocusPainted(false); 
		c50.setFocusPainted(false); 
		c51.setFocusPainted(false); 
		c52.setFocusPainted(false); 
		c53.setFocusPainted(false); 
		c54.setFocusPainted(false); 
		c55.setFocusPainted(false); 
		c56.setFocusPainted(false); 
		c57.setFocusPainted(false); 
		c60.setFocusPainted(false); 
		c61.setFocusPainted(false); 
		c62.setFocusPainted(false); 
		c63.setFocusPainted(false); 
		c64.setFocusPainted(false); 
		c65.setFocusPainted(false); 
		c66.setFocusPainted(false); 
		c67.setFocusPainted(false); 
		c70.setFocusPainted(false); 
		c71.setFocusPainted(false); 
		c72.setFocusPainted(false); 
		c73.setFocusPainted(false); 
		c74.setFocusPainted(false); 
		c75.setFocusPainted(false); 
		c76.setFocusPainted(false); 
		c77.setFocusPainted(false); 
		c60.setForeground(w); 
		c61.setForeground(w); 
		c62.setForeground(w); 
		c63.setForeground(w); 
		c64.setForeground(w); 
		c65.setForeground(w); 
		c66.setForeground(w); 
		c67.setForeground(w); 
		c70.setForeground(w); 
		c71.setForeground(w); 
		c72.setForeground(w); 
		c73.setForeground(w); 
		c74.setForeground(w); 
		c75.setForeground(w); 
		c76.setForeground(w); 
		c77.setForeground(w); 


		
	}
	
	
}


public class chess {
	
	public static void frame()
	{
		JFrame game_frame =new JFrame("Chess");
		
		new obj(game_frame);
		
		game_frame.setSize(1200,750);
		game_frame.setLayout(null);
		game_frame.setVisible(true);
		game_frame.getContentPane().setBackground(Color.decode("#2B3C53"));
		game_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		frame();
	}

}
