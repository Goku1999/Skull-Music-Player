import java.io.*;
class Encrypt
{
    public static void encrypt(String s)
    {
        try
        {
            File f=new File(s);
            FileInputStream fin=new FileInputStream(f);
            DataInputStream din=new DataInputStream(fin);
            byte ar[]=new byte[(int)f.length()];
            din.readFully(ar);
            din.close();
            fin.close();
            f.delete();
            for(int x=0;x<ar.length;x++)
            {
                ar[x]=(byte)(ar[x]^13);
            }
            FileOutputStream fout=new FileOutputStream(f);
            fout.write(ar);
            fout.close();
        }
        catch(Exception e)
        {
        }
    }
}