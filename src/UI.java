import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class UI {

    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);
        String response;
        CompressionHandler compressionHandler;
        do{
            System.out.print("Compress (c) or Decompress (d)? (or 'q' to quit) >>> ");
            response = console.next();
            if(response.equals("c")){
                System.out.print("Enter file name or 'q' to quit >>> ");
                response = console.next();
                if (response.equals("q")){
                    break;
                }
                compressionHandler = new CompressionHandler(response);
                compressionHandler.compress();
                System.out.println(response + " has been compressed into " + response.substring(0, response.length()-3) + "viv");
            }
            else if(response.equals("d")){
                System.out.print("Enter file name or 'q' to quit >>> ");
                response = console.next();
                if (response.equals("q")){
                    break;
                }
                compressionHandler = new CompressionHandler(response);
                compressionHandler.decompress();
                System.out.println(response + " has been decompressed into " + response.substring(0, response.length()-3) + "txt");
            }

        }while(!response.equals("q"));
    }

}
