package com.project;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class run extends TextTranslate
{
    
    public static void main(String[] args) 
    {
        //translate frame
        JFrame translateFrame=new JFrame("Translate");
        JPanel translatePanel=new JPanel();
        JpanelSet.setTranslatePanel(translatePanel);
        translateFrame.setBounds(350, 350, 950, 500);
        translateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        translateFrame.add(translatePanel);
        setMainFrame.SetFrame(translateFrame);

        //audio to text frame
        JFrame audioToTextFrame=new JFrame("Audio to text");
        JPanel audioToTextPanel=new JPanel();
        JpanelSet.setAudioToTextPanel(audioToTextPanel);
        audioToTextFrame.setBounds(350,350,950,500);
        audioToTextFrame.add(audioToTextPanel);



        JFrame welcomeFrame=new JFrame("welcome!");
        JPanel welcomPanel=new JPanel();
        welcomePanelSet.setWelcomePanel(welcomPanel,translateFrame,audioToTextFrame);
        welcomeFrame.setBounds(200,200,400,250);
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.add(welcomPanel);
        setWelcomeFrame.welcomeFrameSet(welcomeFrame);
        welcomeFrame.setVisible(true);
        
    }
    
    
}
