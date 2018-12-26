import javax.swing.*;
import java.awt.*;
import java.io.*;
class Main
{
    public static void main(String args[])
    {
        Music ob=new Music();
        ob.setSize(500,350);
        ob.setResizable(false);
        ob.setTitle("Music Player v 2.1 by Sankalp Srivastava");
        ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ob.setVisible(true);
        /*try
        {
            if(!args[0].equals(""))
            {
                File f=new File(args[0]);
                ob.play(f);
                for(int x=0;x<args.length;x++)
                {
                    ob.temp[x]=new File(args[x]);
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Select a wav file");
        }*/
    }
}