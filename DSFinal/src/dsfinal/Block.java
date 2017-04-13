/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsfinal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Anthony
 */
public class Block extends Rectangle {
    
    final int blockMulti = 15;
    
    public Color color;
    protected boolean isSorted;
    protected int value;
    
    public Block(int x, int y, int w, int value, Color c,boolean iS)
    {
        super(x,y,w,value);
        //super.height = value * blockMulti;
        this.color = c;
        isSorted = iS;
        this.value = value;
    }
    
    public void drawBlock(Graphics g)
    {
        g.setColor(color);
        g.drawRect(super.x, super.y - (value * blockMulti), super.width, (value * blockMulti));
        //g.fillRect(super.x, super.y, super.width, value * blockMulti);
        g.drawString(addZero(value), x+ 6, y + 20);   
    }
    
    public String addZero(int num)
    {
        if(num < 10)
        {
            return "0" + num;
        }
        else
        {
            return num + "";
        }
    }
    
}
