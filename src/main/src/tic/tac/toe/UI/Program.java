package tic.tac.toe.UI;

import tic.tac.toe.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;

public class Program {

    enum ShapeType{
        O,X;

        public GameShape createShape(int[] pos){
            if(this == O){
                return ShapeFactory.newOShape(pos);
            } else if (this == X) {
                return ShapeFactory.newXShape(pos);
            }
            return null;
        }

        public String toString(){
            return this.name();
        }
    }

    static ShapeType currType = ShapeType.O;
    static UIGame game = UITicTacToeGame.start();

    public static void main(String[] args) {
        JFrame window = new JFrame("TIC-TAC-TOE");
        window.setSize(800,600);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel backgroundPanel = new JPanel(new GridBagLayout());
        backgroundPanel.setPreferredSize(new Dimension(780,580));
        backgroundPanel.setBackground(Color.GRAY);


        JPanel gamePanel = new JPanel(){
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                Graphics2D g2d = (Graphics2D) g.create();

                g2d.setStroke(new BasicStroke(4.0f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER));
                g2d.drawRect(0,0,300,300);
                g2d.drawLine(100,0,100,300);
                g2d.drawLine(200,0,200,300);
                g2d.drawLine(0,100,300,100);
                g2d.drawLine(0,200,300,200);

                game.draw(g2d);
            }
        };
        gamePanel.setPreferredSize(new Dimension(300,300));
        gamePanel.setBackground(Color.white);
        gamePanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        gamePanel.setAlignmentY(JComponent.CENTER_ALIGNMENT);
        gamePanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for(int row = 0;row < Game.MAX_ROW;row++){
                    for(int col = 0; col < Game.MAX_COL; col++){
                        if(UITicTacToeGame.positions[row][col].contains(e.getPoint())){
                            int[] pos = new int[]{row,col};
                            GameShape shape = currType.createShape(pos);
                            if(game.canAdd(shape)){
                                game.add(shape);
                                gamePanel.repaint();
                                if(game.isFinished()){
                                    String msg = "It's a draw! Play again?";
                                    if(game.isLine()){
                                        msg = currType.toString()+" wins! Play again?";
                                    }
                                    int n = JOptionPane.showConfirmDialog( window,msg,"Game over",JOptionPane.YES_NO_OPTION);
                                    if(n == 0){
                                        game = UITicTacToeGame.start();
                                        gamePanel.repaint();
                                    }else{
                                        window.dispatchEvent(new WindowEvent(window,WindowEvent.WINDOW_CLOSING));
                                    }
                                }
                                if(currType == ShapeType.O){
                                    currType = ShapeType.X;
                                }else{
                                    currType = ShapeType.O;
                                }
                            }
                        }
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        backgroundPanel.add(gamePanel);

        window.add(backgroundPanel);

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
