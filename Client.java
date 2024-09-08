import java.io.*;
import java.util.*;
import java.net.*;
public class Client{
    public static void main(String[] args)throws IOException
    {
        try(Socket socket=new Socket("localhost",9000);
        Scanner sc=new Scanner(System.in);
        PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
        BufferedReader bReader=new BufferedReader(new InputStreamReader(socket.getInputStream())))
        {
            System.out.println("enter the file name");
            out.println(sc.nextLine());

            String line;
            while((line=bReader.readLine())!=null)
            {
                System.out.println(line);
            }
        }
    }
}