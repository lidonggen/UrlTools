package com.douyu.url;

import java.awt.Dimension;
import javax.swing.JFrame;
public class aaa extends ToolsPanel {
    public aaa(){
        this.setPreferredSize(new Dimension(800, 600));
        this.setVisible(true);
        //this.setSize(new Dimension(800, 600));
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.pack();

    }


    public static void main(String args[]){
        new aaa();
    }
}
