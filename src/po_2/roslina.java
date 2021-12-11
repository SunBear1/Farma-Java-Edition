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
public class roslina extends organizm{
@Override
public void SetX(int x)
{
	this.x = x;
}
@Override
public void SetY(int y)
{
	this.y = y;
}
@Override
public int GetX()
{
	return x;
}
@Override
public int GetY()
{
	return y;
}
@Override
public int GetSila()
{
	return sila;
}
@Override
public char GetID()
{
	return id;
}
@Override
public String GetImie()
{
	return imie;
}
@Override
public void SetImie(String imie)
{
	this.imie = imie;
}
@Override
public void SetSila(int sila)
{
	this.sila = sila;
}
public void Rozmnazanie(organizm rodzic, organizm plansza, int szerokosc, int wysokosc)
{

}
@Override
public void Akcja(swiat planeta)
{

}
@Override
public organizm Kolizja(organizm off, organizm def, swiat planeta)
{
	return def;
}
@Override
public int GetInicjatywa()
{
	return inicjatywa;
}
@Override
public void SetInicjatywa(int inicjatywa)
{
	this.inicjatywa = inicjatywa;
}
@Override
public int GetWiek()
{
	return wiek;
}
@Override
public void SetID(char id)
{
	this.id = id;
}
@Override
public void SetRozmnoz(boolean rozmnoz)
{
	this.rozmnoz = rozmnoz;
}
@Override
public boolean GetRozmnoz()
{
	return rozmnoz;
}
@Override
public void SetWiek(int wiek)
{
	this.wiek = wiek;
}
@Override
public Color Kolor(){
     return Color.RED;
}
}
