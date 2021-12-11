/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zwierzeta;
import po_2.zwierze;
import po_2.organizm;
import po_2.swiat;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author lukin
 */
public class czlowiek extends zwierze{
public czlowiek()
{
	SetSila(5);
	SetInicjatywa(4);
	SetID('C');
	SetWiek(0);
	SetImie("Czlowiek");
}
@Override
public void Akcja(swiat planeta)
{
    int szansa;
	if ((planeta.licznik == 0) && (planeta.wlacz == false))
		planeta.cooldown += 1;
        else if (planeta.wlacz == true && planeta.cooldown > 5)
	{
		if (planeta.licznik < 3)
			planeta.szybkosc = 2;
		else if (planeta.licznik < 5)
		{
			szansa = ThreadLocalRandom.current().nextInt(0, 2);
			if (szansa == 0)
				planeta.szybkosc = 2;
		}
		else
		{
			planeta.wlacz = false;
			planeta.licznik = 0;
			planeta.cooldown = 0;
			planeta.szybkosc = 1;
			System.out.println("ULT przestal dzialac");
		}
	}
	else
	{
            planeta.szybkosc = 1;
            planeta.cooldown += 1;
	}
    planeta.SetRuch(1);
    while (planeta.ruch == 1)
    {
        try
        {
            Thread.sleep(1);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
   SetX(planeta.cx);
   SetY(planeta.cy);
   System.out.println(GetImie()+" poruszył(a) się na "+GetX()+" "+GetY());
}
@Override
public organizm Kolizja(organizm off, organizm def, swiat planeta)
{
	if (def.GetID() == GetID())
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
	else
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
}
