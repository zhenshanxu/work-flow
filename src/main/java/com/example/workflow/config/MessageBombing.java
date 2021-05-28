package com.example.workflow.config;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;

/**
 * @Author : ZhenShan Xu
 * @CreateTime : 2021/5/28 13:46.
 * @Version : 1.0
 * @Description：消息轰炸
 * @修订记录
 **/
public class MessageBombing {

    private static Component jPanel;
    private static Icon icon;

    private static int stop = 0;

    public static void messageBombing(String sentence, int cycleTime) throws AWTException {
        //以下三行为将上述字符串放到剪切板内，相当于做了一次复制操作
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable tText = new StringSelection(sentence);
        clip.setContents(tText, null);
        Robot robot = new Robot();//创建Robot对象
        robot.delay(3000);//延迟三秒，主要是为了预留出打开窗口的时间，括号内的单位为毫秒
        for (int i = 1; i <= cycleTime; i++) {//循环十次，当然，如果爱得深，你死循环也没问题
            if (stop != 0) {
                break;
            }
            //以下两行按下了ctrl+v，完成粘贴功能
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);

            robot.keyRelease(KeyEvent.VK_CONTROL);//释放ctrl按键，像ctrl，退格键，删除键这样的功能性按键，在按下后一定要释放，不然会出问题。crtl如果按住没有释放，在按其他字母按键是，敲出来的回事ctrl的快捷键。
            robot.delay(1000);//延迟一秒再发送，不然会一次性全发布出去，因为电脑的处理速度很快，每次粘贴发送的速度几乎是一瞬间，所以给人的感觉就是一次性发送了全部。这个时间可以自己改，想几秒发送一条都可以
            robot.keyPress(KeyEvent.VK_ENTER);//回车
        }
    }

    /*
     * 判断是否为整数
     * @param str 传入的字符串
     * @return 是整数返回true,否则返回false
     */

    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }


    public static void main(String[] args) throws AWTException {
        String sentence = null;// 定义要发的话
        String cycleTime = null;//定义消息循环次数

        JOptionPane.showMessageDialog(jPanel, "消息轰炸模块已开启", "友情提示", JOptionPane.WARNING_MESSAGE);
        //输入轰炸文字
        do {
            sentence = (String) JOptionPane.showInputDialog(null, "请输入你你想轰炸的内容：\n", "友情提示", JOptionPane.PLAIN_MESSAGE, icon, null, "在这输入");
            if (sentence == null) {
                JOptionPane.showMessageDialog(jPanel, "消息轰炸模块已退出", "友情提示", JOptionPane.WARNING_MESSAGE);
                System.exit(0);//程序退出
                break;
            }
        } while ("".equals(sentence.trim()));

        //输入轰炸次数
        do {
            cycleTime = (String) JOptionPane.showInputDialog(null, "请输入你你想轰炸的次数：\n", "友情提示", JOptionPane.PLAIN_MESSAGE, icon, null, "在这输入数字");
            if (cycleTime == null) {
                JOptionPane.showMessageDialog(jPanel, "消息轰炸模块已退出", "友情提示", JOptionPane.WARNING_MESSAGE);
                System.exit(0);//程序退出
                break;
            }
        } while (!isInteger(cycleTime) || Integer.parseInt(cycleTime) == 0);
        JOptionPane.showMessageDialog(jPanel, "消息轰炸即将开...\n请选择需要轰炸的对象聊天框", "友情提示", JOptionPane.WARNING_MESSAGE);
        messageBombing(sentence, Integer.parseInt(cycleTime));
        JOptionPane.showMessageDialog(jPanel, "消息轰炸已完成", "友情提示", JOptionPane.WARNING_MESSAGE);

    }
}
