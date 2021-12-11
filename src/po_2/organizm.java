/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package po_2;
import java.awt.*;
/**
 *
 * @author lukin
 */
public abstract class organizm {
    protected int sila=0, inicjatywa=0, x=0, y=0,wiek=0;
    protected char id=' ';
    protected boolean rozmnoz = false;
    String imie;
        abstract public void Akcja(swiat planeta);
        abstract public organizm Kolizja(organizm off, organizm def, swiat planeta);
        abstract public void SetX(int x);
	abstract public void SetY(int y);
	abstract public void SetID(char id);
	abstract public void SetImie(String imie);
	abstract public void SetSila(int sila);
	abstract public void SetWiek(int wiek);
	abstract public void SetInicjatywa(int inicjatywa);
	abstract public String GetImie();
	abstract public char GetID();
	abstract public int GetSila();
	abstract public int GetInicjatywa();
	abstract public int GetWiek();
	abstract public int GetX();
	abstract public int GetY();
        abstract public Color Kolor();
        abstract public boolean GetRozmnoz();
        abstract public void SetRozmnoz(boolean rozmnoz);
}
