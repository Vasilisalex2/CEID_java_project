import java.io.*;
public class FileEditor{
    public static void main(String[] args){
        try{
         FileReader fil1 = new FileReader("input1.txt");
         FileReader fil2 = new FileReader("input2.txt");
         FileWriter merg = new FileWriter("merged.txt");
         int charRead;
         int count=0;
         merg.write("input1:");
         while ((charRead = fil1.read()) != -1) //έχουμε EOF αν επιστρέψει -1, αλλιώς επιστρέφει τον χαρακτήρα σε κώδικα ASCII
         {  if(charRead==46) count++;                       //ASCII 46 = '.'
            if(charRead==33) { merg.write(46); count++; }   //ASCII 33 = '!', 46 = '.'
            else merg.write(charRead);}         //γράφει τον char στον οποίο αντιστοιχεί ο αριθμός στον ASCII
         merg.write(" input2:");
         while ((charRead = fil2.read()) != -1) 
         {  if(charRead==46) count++;
            if(charRead==33) { merg.write(46); count++; }
            else merg.write(charRead);  }            
         fil1.close();     
         fil2.close();
         merg.close();
         File input1 = new File("input1.txt");
         File input2 = new File("input2.txt");
         File merged = new File("merged.txt");
         System.out.println("input1.txt length = "+input1.length()+" bytes");
         System.out.println("input2.txt length = "+input2.length()+" bytes");
         System.out.println("merged.txt length = "+merged.length()+" bytes");
         System.out.println("merged.txt includes "+count+" occurences of the '.' character");
        } catch (FileNotFoundException fnfe){
            System.out.println("No such file found");   
        } catch (IOException e) {}
    }
}
