
    import java.io.*;
    import java.util.ArrayList;
     
     
    class spam 
    {
    	public String msg = new String();
    	public int state;//if spam then 1 else 0
     
    	spam(String mesg, int s) {
    		msg = mesg;
    		state = s;
    }
     
    	public void setMsg(String m) 
    	{
    		this.msg = m;
    	}	
    	public void setMsg(int s) 
    	{
    		this.state = s;
    	}	
    }
    class Readfile 
    {
     
    	private String path;
    	public Readfile(String file_path)
    	{
    		path=file_path;
    	}	
    	public String[] Openfile() throws IOException
    	{
    		FileReader fr=new FileReader(path);
    		BufferedReader textReader=new BufferedReader(fr);
    		String []textData= new String[17];
    		int i;
    		for(i=0;i<17;i++)
    		{
    			textData[i]=textReader.readLine();
    		}
    		textReader.close();
    		return textData;
    	}
    }
     
    public class Filedata
    {
    	public static void main(String[] args) throws IOException
    	{
    		String file_name="sms.txt";
    		try{
    			Readfile file=new Readfile(file_name);
    			String[] aryData=file.Openfile();
    			ArrayList<spam> S=new ArrayList<spam>();
    			for(String line: aryData)
    			{
    				System.out.println(line);
    				String[] bits=line.split(",");
    				String last=bits[bits.length-1];
    				spam s;
    				if(last.equals("spam"))
    					s = new spam(line, 1);
    				if (last.equals("ham"))
    					s = new spam(line, 0);
    			}
    			for(int i=0;i<aryData.length;i++)
    			{
    				System.out.println(aryData[i]);
    			}
    		}
    		catch(IOException e)
    		{
    			System.out.println(e.getMessage());
    		}
    	}
    }
