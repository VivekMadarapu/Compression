import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class UI {

    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);
        String response;
        CompressionHandler compressionHandler = null;
        do{
            System.out.print("Compress (c) or Decompress (d)? (or 'q' to quit) >>> ");
            response = console.next();
            console.nextLine();
            if(response.equals("c")){
                System.out.print("Enter file name >>> ");
                response = console.nextLine();

                compressionHandler = new CompressionHandler(response);
                compressionHandler.compress();
                System.out.println(compressionHandler.input.getName() + " has been compressed into " + compressionHandler.output.getName());
            }
            else if(response.equals("d")){
                System.out.print("Enter file name or 'last' to use the file in stream >>> ");
                response = console.nextLine();
                if(!response.equals("last")) {
                    compressionHandler = new CompressionHandler(response);
                }
                compressionHandler.decompress();
                System.out.println(compressionHandler.output.getName() + " has been decompressed into " + compressionHandler.output.getName() + ".txt");
            }

        }while(!response.equals("q"));
    }

}
