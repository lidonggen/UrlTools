package com.douyu.url;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

class ToolsPanel extends JFrame {

    JPanel panel;
    boolean start;
    JLabel display;

    public static void main(String[] args) {
        new ToolsPanel();
    }
    public ToolsPanel() {
        setTitle("斗鱼URL启动小工具");
        this.setLocation(400, 200);
        this.setVisible(true);
        this.setPreferredSize(new Dimension(800, 600));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        this.start = true;
        this.display = new JLabel();
        this.display.setFont(new Font("Dialog", 1, 15));
        this.display.setText("请点击你想要的按钮...");
        this.panel = new JPanel();
        this.panel.setLayout(new GridLayout(4, 4));
        UrlToolsAction urlToolsAction = new UrlToolsAction();


        addButton(CommonParas.workSummary, urlToolsAction);
        addButton(CommonParas.pmJieNiu, urlToolsAction);
        addButton(CommonParas.oaSystem, urlToolsAction);
        addButton(CommonParas.developeWeb, urlToolsAction);
        addButton(CommonParas.preReleaseWeb, urlToolsAction);
        addButton(CommonParas.releaseWeb, urlToolsAction);
        addButton(CommonParas.loginCachclean, urlToolsAction);
        addButton(CommonParas.preReleaseBackGround, urlToolsAction);
        addButton(CommonParas.autoTest, urlToolsAction);
        addButton(CommonParas.bugPM, urlToolsAction);


        add(BorderLayout.NORTH, display);
        add(panel, BorderLayout.CENTER);
    }



    private void addButton(String str, ActionListener actionListener) {
        JButton button = new JButton(str);
        button.addActionListener(actionListener);
        this.panel.add(button);
    }

    class UrlToolsAction implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String input = e.getActionCommand();

            switch (input) {
                case CommonParas.workSummary:
                    launch(CommonParas.workSummaryUrl, input, null, null);
                    break;
                case CommonParas.pmJieNiu:
                    launch(CommonParas.pmJieNiuUrl, input, null, null);
                    break;
                case CommonParas.oaSystem:
                    launch(CommonParas.oaSystemUrl, input, null, null);
                    break;
                case CommonParas.developeWeb:
                    launch(CommonParas.developeWebUrl, input, null, null);
                    break;
                case CommonParas.preReleaseWeb:
                    launch(CommonParas.preReleaseWebUrl, input, null, null);
                    break;
                case CommonParas.releaseWeb:
                    launch(CommonParas.releaseWebUrl, input, null, null);
                    break;
                case CommonParas.loginCachclean:
                    launch(CommonParas.loginCachcleanUrl, input, null, null);
                    break;
                case CommonParas.preReleaseBackGround:
                    launch(CommonParas.preReleaseBackGroundUrl, input, null, null);
                    break;
                case CommonParas.autoTest:
                    launch(CommonParas.autoTestUrl, input, CommonParas.autoTestUserName, CommonParas.autoTestPassWord);
                    break;
                case CommonParas.bugPM:
                    launch(CommonParas.bugPMUrl, input, null, null);
            }
        }

        public void launch(String strurl, String input, String username, String password) {
            Desktop desktop = null;
            URI uri = null;
            try {
                uri = new URI(strurl);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            if (Desktop.isDesktopSupported()) {
                desktop = Desktop.getDesktop();
            }
            if (desktop != null) {
                try {
                    desktop.browse(uri);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if ((username == null) || (password == null)) {
                ToolsPanel.this.display.setText("<html>您选择的平台是：" + input + "<br>" + "无账号密码信息");
            } else
                ToolsPanel.this.display.setText("<html>您选择的平台是：" + input + "<br>账号：" + username + "<br>密码：" + password + "</html>");
        }
    }
}