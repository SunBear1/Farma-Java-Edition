/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zwierzeta;
import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;
import po_2.zwierze;
import po_2.organizm;
import po_2.swiat;
import rosliny.barszcz;
/**
 *
 * @author lukin
 */
public class cyberowca extends zwierze{
public cyberowca()
{
    SetSila(11);
    SetInicjatywa(4);
    SetID('R');
    SetWiek(0);
    SetImie("Cyberowca");
    
}
private void Rozmnazanie(organizm rodzic, swiat planeta)
{
	boolean []brakruchu = new boolean[]{false,false,false,false};
        int kierunek;
	while (true)
	{
		if (brakruchu[0] && brakruchu[1] && brakruchu[2] && brakruchu[3])
			break;
		kierunek = ThreadLocalRandom.current().nextInt(0, 4);
		if (kierunek == 0)
		{
			if (rodzic.GetY() > 0)
			{
                                
				if (!(planeta.plansza[rodzic.GetX()][rodzic.GetY() - 1] instanceof organizm))
				{
					organizm dziecko = new cyberowca();
					dziecko.SetX(rodzic.GetX());
					dziecko.SetY(rodzic.GetY() - 1);
					planeta.plansza[rodzic.GetX()][rodzic.GetY() - 1] = dziecko;
					System.out.println(dziecko.GetImie()+" rozmnozyla się na "+dziecko.GetX()+" "+dziecko.GetY());
					break;
				}
				else
					brakruchu[kierunek] = true;
			}
			else
			{
				brakruchu[kierunek] = true;
				kierunek = ThreadLocalRandom.current().nextInt(0, 4);
			}
		}
		else if (kierunek == 1)
		{
			if (rodzic.GetY() < planeta.szerokosc - 1)
			{
                           
				if ( !(planeta.plansza[rodzic.GetX()][rodzic.GetY() + 1] instanceof organizm))
				{
					organizm dziecko = new cyberowca();
					dziecko.SetX(rodzic.GetX());
					dziecko.SetY(rodzic.GetY() + 1);
					planeta.plansza[rodzic.GetX()][rodzic.GetY() + 1] = dziecko;
					System.out.println(dziecko.GetImie()+" rozmnozyla się na "+dziecko.GetX()+" "+dziecko.GetY());
					break;
				}
				else
					brakruchu[kierunek] = true;
			}
			else
			{
				brakruchu[kierunek] = true;
				kierunek = ThreadLocalRandom.current().nextInt(0, 4);
			}
		}
		else if (kierunek == 2)
		{
			if (rodzic.GetX() < planeta.wysokosc - 1)
			{
				if (!(planeta.plansza[rodzic.GetX() + 1][rodzic.GetY()] instanceof organizm))
				{
					organizm dziecko = new cyberowca();
					dziecko.SetX(rodzic.GetX() + 1);
					dziecko.SetY(rodzic.GetY());
					planeta.plansza[rodzic.GetX() + 1][rodzic.GetY()] = dziecko;
					System.out.println(dziecko.GetImie()+" rozmnozyla się na "+dziecko.GetX()+" "+dziecko.GetY());
					break;
				}
				else
					brakruchu[kierunek] = true;
			}
			else
			{
				brakruchu[kierunek] = true;
				kierunek = ThreadLocalRandom.current().nextInt(0, 4);
			}
		}
		else
		{
			if (rodzic.GetX() > 0)
			{
				if (!(planeta.plansza[rodzic.GetX() - 1][rodzic.GetY()] instanceof organizm))
				{
					organizm dziecko = new cyberowca();
					dziecko.SetX(rodzic.GetX() - 1);
					dziecko.SetY(rodzic.GetY());
					planeta.plansza[rodzic.GetX() - 1][rodzic.GetY()] = dziecko;
					System.out.println(dziecko.GetImie()+" rozmnozyla się na "+dziecko.GetX()+" "+dziecko.GetY());
					break;
				}
				else
					brakruchu[kierunek] = true;
			}
			else
			{
				brakruchu[kierunek] = true;
				kierunek = ThreadLocalRandom.current().nextInt(0, 4);
			}
		}
	}
}
@Override
public void Akcja(swiat planeta)
{
    int y = GetY();
    int x = GetX();
    int kierunek,odleglosc=999,xx,yy,tmp,bx=0,by=0;
    for (int i=0;i<planeta.szerokosc;i++)
    {
        for (int j=0;j<planeta.wysokosc;j++)
        {
            if(planeta.plansza[i][j] instanceof barszcz)
            {
                xx = planeta.plansza[i][j].GetX() - GetX();
                yy = planeta.plansza[i][j].GetY() - GetY();
                tmp = xx*xx + yy*yy;
                if(tmp < odleglosc)
                {
                    odleglosc = tmp;
                    bx=planeta.plansza[i][j].GetX();
                    by=planeta.plansza[i][j].GetY();     
                }      
            }
        }
    }
    if(odleglosc!=999)
    {
        if(GetX()!=bx)
        {
            if(bx>GetX())
                SetX(x+1);
            else
                SetX(x-1);
        }
        else if(GetY()!=by)
        {
            if(by>GetY())
                SetY(y+1);
            else
                SetY(y-1);
        }      
    }
    else
    {
        while (true)
	{
		kierunek = ThreadLocalRandom.current().nextInt(0, 4);
		if (kierunek == 0)
		{
			if (y > 0)
			{
				SetY(y - 1);
				break;
			}
			else
				kierunek = ThreadLocalRandom.current().nextInt(0, 4);
		}
		else if (kierunek == 1)
		{
			if (y < planeta.szerokosc - 1)
			{
				SetY(y + 1);
				break;
			}
			else
				kierunek = ThreadLocalRandom.current().nextInt(0, 4);

		}
		else if (kierunek == 2)
		{
			if (x < planeta.wysokosc - 1)
			{
				SetX(x + 1);
				break;
			}
			else
				kierunek = ThreadLocalRandom.current().nextInt(0, 4);
		}
		else
		{
			if (x > 0)
			{
				SetX(x - 1);
				break;
			}
			else
				kierunek = ThreadLocalRandom.current().nextInt(0, 4);
		}
	}
    }
    System.out.println(GetImie()+" poruszył(a) się na "+GetX()+" "+GetY());
}
@Override
public organizm Kolizja(organizm off, organizm def, swiat planeta)
{
	if (def.GetID() == off.GetID())
	{
		off.SetRozmnoz(true);//rozmnoz było przez referencje
		Rozmnazanie(def, planeta);
		return def;
	}
	else if (def.GetID() == GetID()) //owca broni
	{
		if (def.GetSila() > off.GetSila())
		{
			System.out.println(def.GetImie()+" wygyrwa z "+off.GetImie());
			return def;
		}
		else
		{
			System.out.println(def.GetImie()+" przegrywa z "+off.GetImie());
			return off;
		}

	}
        else if(def instanceof barszcz)
        {
            System.out.println(off.GetImie()+" konsumuje ze smakiem "+def.GetImie());
            return off;
        }
	else //owca atakuje
	{
		if (off.GetSila() > def.GetSila())
		{
			if (off == def.Kolizja(off, def, planeta)) //broniący sprawdza czy jego super skille go obroniły
			{
				System.out.println(off.GetImie()+" wygyrwa z "+def.GetImie());
				return off;
			}
			else
				return def;
		}
                else
		{
			System.out.println(off.GetImie()+" przegrywa z "+def.GetImie());
			return def;
		}
	}
}
@Override
public Color Kolor() {
      return new Color(0, 102, 102);
}
}
