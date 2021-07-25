package com.javawork28;

// ����С�����Ĵ���

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class BallPanel extends JFrame {
	
	private JPanel mainPanel = new JPanel();        // С������panel
	private JPanel operatePanel = new JPanel();     // �·���ť��panel
	
	public BallPanel() {
		
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());
		
		this.mainPanel.setBackground(Color.BLACK);     // ��mainPanel�ı�����ɫ��Ϊ��ɫ
		c.add(this.mainPanel, BorderLayout.CENTER);    // ��mainPanel��ӽ�ContentPaneʵ����c
		
		
		JButton b1 = new JButton("��ʼ");
		// ����ʼ��ť���ü�����ֱ����addActionListener()������ʵ����ActionListener��ӷ�����ʵ����С��Ball��ִ���̵߳�start����
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ball b = new Ball(mainPanel);
				b.start();
			}	
		});
		
		
		JButton b2 = new JButton("�˳�");
		// ����ʼ��ť���ü�����ֱ����addActionListener()������ʵ����ActionListener��ӷ���
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		// ��������ť��ӽ��ײ���ťpanel
		this.operatePanel.add(b1);
		this.operatePanel.add(b2);
		c.add(this.operatePanel, BorderLayout.SOUTH);
		
		this.setBounds(650, 200, 600, 600);
		this.setTitle("С����Ϸ  by wyh");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

