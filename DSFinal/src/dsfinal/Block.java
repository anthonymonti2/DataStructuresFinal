/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsfinal;

import java.awt.Color;
import java.awt.Rectangle;

/**
 *
 * @author Anthony
 */
public class Block extends Rectangle {
    
    public Color color;
    protected boolean isSorted;
    
    public Block(int x, int y, int w, int h, Color c,boolean iS)
    {
        super(x,y,w,h);
        this.color = c;
        isSorted = iS;
    }
    
}