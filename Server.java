import java.io.*;
import java.net.*;
public class Server{
    public static void main(String[] args)throws IOException, InterruptedException{
        try(ServerSocket serversocket=new ServerSocket(9000))
        {
            System.out.println("server is running");
            try(Socket socket=serversocket.accept();
            BufferedReader bReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out=new PrintWriter(socket.getOutputStream(),true);)
            {
                String filename=bReader.readLine();
                System.out.println("file is found"+filename);

                File file=new File("Client.txt");
                if(filename.equals(file.getName()))
                {
                    System.out.println("file found");
                    try(BufferedReader fileReader=new BufferedReader(new FileReader(file)))
                    {
                       String line;
                       while((line=fileReader.readLine())!=null)
                       {
                            out.println(line);
                            Thread.sleep(2000);
                       } 
                    }
                }
                else{
                    System.out.println("file not found");
                    out.println("file not found");
                }
            }
        }
    }
}