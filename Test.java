package com.bilgeadam.startup;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		MenuBuilder builder = MenuBuilder.getMenuBuilder();
		Menu menu = builder.etDonerMenu();
		System.out.println(menu.toplam());
	}

}
interface Paketleme { public String paketleme();}
interface Cesit {
	public String ad();
	public Paketleme paketle();
	public double fiyat();
}
class EkmekArasi implements Paketleme { public String paketleme() { return "ekmek arasi";} }
class Icecek implements Paketleme { public String paketleme() { return "kutu icecek";} }
abstract class Doner implements Cesit { public Paketleme paketle() { return new EkmekArasi();}}
abstract class SogukIcecek implements Cesit{ public Paketleme paketle() { return new Icecek(); }}
class Kola extends SogukIcecek {
	public double fiyat() { return 2.0; }
	public String ad() { return "coca cola"; }
}
class Pepsi extends SogukIcecek {
	public double fiyat() { return 1.8; }
	public String ad() { return "pepsi"; }
}
class TavukDoner extends Doner {
	  public double fiyat() { return 6.5; }
	  public String ad() { return "tavuk doner"; }
}
class EtDoner extends Doner {
	public double fiyat() { return 17.5; }
	public String ad() { return "et doner"; }
}
class Menu {
	private ArrayList<Cesit> cesitler = new ArrayList<Cesit>();
	public void cesitEkle(Cesit cesit) { cesitler.add(cesit); }
	public double toplam(){
		double toplam =0;
		for(Cesit cesit:cesitler){
			toplam = cesit.fiyat();
		}
		return toplam;
	}
}
class MenuBuilder {
	private static final MenuBuilder builder= new MenuBuilder();
	private MenuBuilder() {  }
	public static MenuBuilder getMenuBuilder() { return builder;}
	public Menu etDonerMenu() {
		Menu menu = new Menu();
		menu.cesitEkle(new EtDoner());
		menu.cesitEkle(new Pepsi());
		return menu;
	}
	public Menu tavukDonerMenu(){
		Menu menu = new Menu();
		menu.cesitEkle(new TavukDoner());
		menu.cesitEkle(new Pepsi());
		return menu;
	}
}


