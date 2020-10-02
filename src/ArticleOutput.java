import java.util.Vector;

public class ArticleOutput {

    private Vector<String> lineText;
    private String type;
    private String bubble;
    private String finalResult="";
    int lineLength;

    public ArticleOutput(Vector<String> lineText,int lineLength,String type,String bubble)
    {
        this.lineLength=lineLength;
        this.lineText=lineText;
        this.type=type;
        this.bubble=bubble;

    }

    private String getSpaces(int length)
    {
        String a="";
        for(int i=0;i<length;i++)
            a+=" ";
        return a;
    }
    private void solve()
    {
        //
        for(String line:lineText)
        {
            String temp=line;
            int bias=lineLength-temp.length();
            if(type.equals("L"))
            {
                temp=getSpaces(bias)+temp;
            }
            else if(type.equals("R"))
            {
                temp+=getSpaces(bias);
            }
            else    //C
            {
                int bias1=0;
                int bias2=0;
                if(bias%2==0)
                {
                    bias1=bias2=bias/2;
                }
                else
                {
                    bias1=bias/2+1;
                    bias2=bias/2;
                }

                temp=getSpaces(bias1)+temp+getSpaces(bias2);
            }

            if(bubble.equals("YES"))
            {
                temp="|"+temp+"|";
            }
            temp+="\n";
            finalResult+=temp;
        }

    }

    public String getResult()
    {
        solve();
        return finalResult;
    }
}
