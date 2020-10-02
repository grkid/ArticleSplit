import java.io.IOException;

public class Main {
    static String test="Cookies and IP addresses allow us to deliver and improve our web content and to provide you with a personalized experience. Our website uses cookies and collects your IP address for these purposes.";
    static String type="L";
    static String bubble="NO";
    static int lineLength=50;

    public static boolean argCheck(String[] args)
    {

        return true;

    }

    public static void printBubbleLine(int length)
    {
        for(int i=0;i<length;i++)
            System.out.print("-");
        System.out.print("\n");
    }

    public static void main(String[] args)
            throws IOException
    {
        //filename length [mode]
        if(!argCheck(args))
            return;
        ArticleReader r=new ArticleReader(args[0]);
        if(args.length==3)
        {
            if(args[2].equals("B"))
                bubble="YES";
            else
                type=args[2];
        }

        String finalResult="";
        String[] input=r.getResult().split("\n");
        for(String s:input) {
            ArticleController c = new ArticleController(s, Integer.parseInt(args[1])+1, type, bubble);
            finalResult+=c.getResult();
        }
        if(bubble.equals("YES"))
        {
            printBubbleLine(Integer.parseInt(args[1]));
            System.out.println(finalResult);
            printBubbleLine(Integer.parseInt(args[1]));
        }
        else
            System.out.println();
    }
}
