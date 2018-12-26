import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;
import java.applet.AudioClip;
class Music extends JFrame implements ActionListener
{
    JButton b10=new JButton("Open");
    JButton b1=new JButton();
    JButton b=new JButton();
    JButton b2=new JButton();
    JButton b3=new JButton();
    JButton b4=new JButton();
    JButton b5=new JButton();
    JButton b6=new JButton();
    JLabel back;
    JTextField l=new JTextField();
    JLabel t=new JLabel("Music Plyer");
    long lg;
    String skin="C:\\Users\\Sankalp\\Documents\\Skull Music Player\\back1.jpg";
    JTextField t1=new JTextField(); 
    boolean shuffle=false;
    boolean loop=false;
    String name="";
    File sound;
    int r=0;
    Clip clip;
    AudioInputStream aud;
    File f[];
    File temp[];
    String dir="";
    Icon i;
    public Music()
    {
        setLayout(null);

        
        back=new JLabel();
        Encrypt.encrypt(skin);
 
        i=new ImageIcon(skin);
        back.setIcon(i);
        
        Encrypt.encrypt(skin); 
        Encrypt.encrypt("C:\\Users\\Sankalp\\Documents\\Skull Music Player\\play.jpg");
        i=new ImageIcon("C:\\Users\\Sankalp\\Documents\\Skull Music Player\\play.jpg");
        b1.setIcon(i);
        Encrypt.encrypt("C:\\Users\\Sankalp\\Documents\\Skull Music  Player\\play.jpg");
        
        Encrypt.encrypt("C:\\Users\\Sankalp\\Documents\\Skull Music Player\\pause.png");
        i=new ImageIcon("C:\\Users\\Sankalp\\Documents\\Skull Music Player\\pause.png");
        b.setIcon(i);
        Encrypt.encrypt("C:\\Users\\Sankalp\\Documents\\Skull Music Player\\pause.png"); 

        Encrypt.encrypt("C:\\Users\\Sankalp\\Documents\\Skull Music Player\\stop.png");
        i=new ImageIcon("C:\\Users\\Sankalp\\Documents\\Skull Music Player\\stop.png");
        b2.setIcon(i);
        Encrypt.encrypt("C:\\Users\\Sankalp\\Documents\\Skull Music Player\\stop.png");   

        Encrypt.encrypt("C:\\Users\\Sankalp\\Documents\\Skull Music Player\\shuffle.png");
        i=new ImageIcon("C:\\Users\\Sankalp\\Documents\\Skull Music Player\\shuffle.png");
        b3.setIcon(i);
        Encrypt.encrypt("C:\\Users\\Sankalp\\Documents\\Skull Music Player\\shuffle.png");   

        Encrypt.encrypt("C:\\Users\\Sankalp\\Documents\\Skull Music Player\\next.png");
        i=new ImageIcon("C:\\Users\\Sankalp\\Documents\\Skull Music Player\\next.png");
        b4.setIcon(i);
        Encrypt.encrypt("C:\\Users\\Sankalp\\Documents\\Skull Music Player\\next.png");   

        Encrypt.encrypt("C:\\Users\\Sankalp\\Documents\\Skull Music Player\\prev.png");
        i=new ImageIcon("C:\\Users\\Sankalp\\Documents\\Skull Music Player\\prev.png");
        b5.setIcon(i);
        Encrypt.encrypt("C:\\Users\\Sankalp\\Documents\\Skull Music Player\\prev.png");   

        Encrypt.encrypt("C:\\Users\\Sankalp\\Documents\\Skull Music Player\\loop.png");
        i=new ImageIcon("C:\\Users\\Sankalp\\Documents\\Skull Music Player\\loop.png");
        b6.setIcon(i);
        Encrypt.encrypt("C:\\Users\\Sankalp\\Documents\\Skull Music Player\\loop.png");    
        back.setBounds(0,-90,500,500);
        t.setBounds(190,100,100,20);
        b10.setBounds(10,-0,100,20);
        b1.setBounds(50,150,100,20);
        b.setBounds(160,150,100,20);
        b2.setBounds(270,150,100,20);
        b3.setBounds(380,150,50,20);
        b4.setBounds(50,200,100,20);
        b5.setBounds(160,200,100,20);
        b6.setBounds(270,200,100,20);
        t1.setBounds(50,270,400,20);
        l.setBounds(50,300,400,20);
        t1.setEditable(false);
        b1.addActionListener(this);
        b.addActionListener(this);
        b10.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b5.addActionListener(this);
        b4.addActionListener(this);
        b6.addActionListener(this);
        add(back);
        //add(l);
        add(b);
        add(b10);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(t1);
        l.setEditable(false);
        b1.setEnabled(false);
        b.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        b6.setEnabled(false);
        add(t);
    }

    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()==b10)
        {
            JFileChooser fc=new JFileChooser("c:\\");
            fc.showOpenDialog(null);
            sound=fc.getSelectedFile();
            b1.setEnabled(true);
            b2.setEnabled(true);
            b3.setEnabled(true);
            b4.setEnabled(true);
            b5.setEnabled(true);
            b6.setEnabled(true);
            b.setEnabled(true);
            String s=sound.getPath();
            String ext=s.substring(s.lastIndexOf(".")+1);
            dir=s.substring(0,s.lastIndexOf("\\"));
            if(ext.equals("wav"))
            {
                play(sound);
            }
            File ob=new File(dir);
            temp=ob.listFiles();
            int i=0;
            for(int x=0;x<temp.length;x++)
            {
                if(!temp[x].isDirectory())
                {
                    String sa=temp[x].getPath();
                    ext=sa.substring(sa.lastIndexOf(".")+1);
                    if(ext.equals("wav"))
                    {                    
                        i++;
                    }
                }
            }
            f=new File[i];
            i=0;
            for(int x=0;x<temp.length;x++)
            {
                if(!temp[x].isDirectory())
                {
                    String sa=temp[x].getPath();
                    ext=sa.substring(sa.lastIndexOf(".")+1);
                    if(ext.equals("wav"))
                    {           
                        f[i]=temp[x];
                        i++;
                    }
                }
            }
            for(int x=0;x<f.length;x++)
            {
                if(sound.getPath().equals(f[x].getPath()))
                {
                    r=x;
                    break;
                }
            }
            /*if(shuffle)
            {                
            int a=2;
            int l=f.length-1;
            int r=(int)(a+(Math.random()*l));
            play(f[r]);
            }
            else
            {
            if(!clip.isActive())
            {
            try
            {
            if(r+1<f.length)
            {
            play(f[r]);
            }
            }
            catch(Exception e)
            {
            r=2;
            play(f[2]);
            }
            }
            }*/
        }
        else if(evt.getSource()==b1)
        {
            try
            {
                clip.start();
                clip.setMicrosecondPosition(lg);
                lg=0;
            }
            catch(Exception e)
            {                
                System.out.println(e);
            }
        }
        else if(evt.getSource()==b)
        {
            lg=clip.getMicrosecondPosition();
            clip.stop();
        }
        else if(evt.getSource()==b2)
        {
            clip.stop();
            clip.close();
            b10.setEnabled(true);
            b1.setEnabled(false);
            b.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
        }
        else if(evt.getSource()==b3)
        {
            shuffle=!shuffle;
        }
        else if(evt.getSource()==b4)
        {
            try
            {
                clip.stop();
                clip.close();
                if(shuffle)
                {
                    int a=0;
                    int l=f.length-1;
                    int r=(int)(a+(Math.random()*l));
                    String s=f[r].getPath();
                    String ext=s.substring(s.lastIndexOf(".")+1);
                    if(ext.equals("wav")&&(!f[r].isDirectory()))
                    {
                        play(f[r]);
                    }                        
                }
                else
                {
                    try
                    {
                        if(r+1<f.length)
                        {
                            r++;
                            String s=f[r].getPath();
                            String ext=s.substring(s.lastIndexOf(".")+1);
                            if(ext.equals("wav")&&(!f[r].isDirectory()))
                            {
                                play(f[r]);
                            } 
                        }
                        else
                        {
                            r=0;
                            String s=f[r].getPath();
                            String ext=s.substring(s.lastIndexOf(".")+1);
                            if(ext.equals("wav")&&(!f[r].isDirectory()))
                            {
                                play(f[r]);
                            } 
                        }
                    }
                    catch(Exception e)
                    {
                        r=2;
                        play(f[2]);
                    }
                }
            }
            catch(Exception e)
            {
                r=2;
                play(f[r]);
            }
        }
        else if(evt.getSource()==b5)
        {
            try
            {
                clip.stop();
                clip.close();
                if(r-1>0)
                {
                    r-=1;
                    String s=f[r].getPath();
                    String ext=s.substring(s.lastIndexOf(".")+1);
                    if(ext.equals("wav")&&(!f[r].isDirectory()))
                    {
                        play(f[r]);
                    } 
                    else
                    {
                    }
                }
                else
                {
                    r=f.length-1;
                    String s=f[r].getPath();
                    String ext=s.substring(s.lastIndexOf(".")+1);
                    if(ext.equals("wav")&&(!f[r].isDirectory()))
                    {
                        play(f[r]);
                    } 
                }
            }
            catch(Exception e)
            {
                r=2;
                String s=f[r].getPath();
                String ext=s.substring(s.lastIndexOf(".")+1);
                if(ext.equals("wav")&&(!f[r].isDirectory()))
                {
                    play(f[r]);
                } 
                else
                {
                }
            }
        }
        else if(evt.getSource()==b6)
        {
            loop=true;
        }
        
    }

    public void play(File sound)
    {
        try
        {
            String s=sound.getPath();            
            name=s.substring(s.lastIndexOf("\\")+1);            
            aud=AudioSystem.getAudioInputStream(sound);
            clip=AudioSystem.getClip();
            clip.open(aud);
            long time=clip.getMicrosecondLength();
            double d1=time/10000.0;
            /*int n=(int)time%60000;
            d1=(int)d1;
            String s1=String.valueOf(d1);*/
            t1.setText(name);
            //l.setText("Running Time :"+d1/*+":"+n*/);
            if(loop)
            {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            else
            {
                clip.start();
            }
            b2.setEnabled(true);
            b3.setEnabled(true);        
        }
        catch(UnsupportedAudioFileException e)
        {
            System.out.println(e);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        catch(LineUnavailableException e)
        {
            System.out.println(e);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}