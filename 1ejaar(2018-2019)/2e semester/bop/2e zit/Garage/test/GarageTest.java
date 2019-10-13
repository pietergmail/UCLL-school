import domain.Auto;
import domain.Garage;
import org.junit.Test;

public class GarageTest
{
  private Garage garage5autos;
  private Garage legeShowroom;
  private Auto bmw1;
  
  public GarageTest() {}
  
  @org.junit.Before
  public void setUp() {
    bmw1 = new Auto("BMW", "wit", 33000.0D);
    bmw2 = new Auto("BMW", "zwart", 44000.0D);
    bmw3 = new Auto("BMW", "zwart", 55000.0D);
    bmw4 = new Auto("BMW", "zwart", 66000.0D);
    bmw5 = new Auto("BMW", "zilver", 77000.0D);
    garage5autos = new Garage("5", 5);
    garage5autos.voegAutoToe(bmw1);
    garage5autos.voegAutoToe(bmw2);
    garage5autos.voegAutoToe(bmw3);
    garage5autos.voegAutoToe(bmw4);
    garage5autos.voegAutoToe(bmw5);
    
    legeShowroom = new Garage("Empty", 10); }
  
  private Auto bmw2;
  
  @Test
  public void test_constructor_Geldige_naam_en_geldig_aantal_wagens_Wordt_aanvaard() { Garage tweedeHands = new Garage("TweedeHands", 80);
    org.junit.Assert.assertEquals("TweedeHands", tweedeHands.getNaam());
    org.junit.Assert.assertEquals(0L, tweedeHands.telTotaalAantalAutosInGarage()); }
  
  private Auto bmw3;
  
  @Test(expected=IllegalArgumentException.class)
  public void test_constructor_Null_als_naam_Gooit_exception() { Garage tweedeHands = new Garage(null, 80); }
  
  private Auto bmw4;
  private Auto bmw5;
  @Test(expected=IllegalArgumentException.class)
  public void test_constructor_Lege_naam_Gooit_exception() { Garage tweedeHands = new Garage("   ", 80); }
  
  @Test(expected=IllegalArgumentException.class)
  public void test_constructor_Negatief_aantal_wagens_Gooit_exception()
  {
    Garage tweedeHands = new Garage("TweedeHands", -80);
  }
  
  @Test
  public void test_setNaam_Geldige_naam_Wordt_aanvaard() {
    garage5autos.setNaam("vijf");
    org.junit.Assert.assertEquals("vijf", garage5autos.getNaam());
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void test_setNaam_Null_als_naam_Gooit_exception() {
    garage5autos.setNaam(null);
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void test_setNaam_Lege_naam_Gooit_exception() {
    garage5autos.setNaam("");
  }
  
  @Test
  public void test_voegAutoToe_Geldige_auto_BMW_zwart_88000_Wordt_toegevoegd() {
    org.junit.Assert.assertEquals(5L, garage5autos.telTotaalAantalAutosInGarage());
    Auto bmw6 = new Auto("BMW", "zwart", 88000.0D);
    garage5autos.voegAutoToe(bmw6);
    org.junit.Assert.assertEquals(6L, garage5autos.telTotaalAantalAutosInGarage());
    org.junit.Assert.assertTrue(bmw6.equals(garage5autos.getAutoOpPositie(5)));
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void test_voegAutoToe_Null_als_auto_Gooit_exception() {
    garage5autos.voegAutoToe(null);
  }
  
  @Test
  public void test_verwijderAuto_Geldige_auto_bmw5_Wordt_verwijderd() {
    org.junit.Assert.assertEquals(5L, garage5autos.telTotaalAantalAutosInGarage());
    garage5autos.verwijderAuto(bmw5);
    org.junit.Assert.assertEquals(4L, garage5autos.telTotaalAantalAutosInGarage());
    org.junit.Assert.assertTrue(bmw4.equals(garage5autos.getAutoOpPositie(3)));
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void test_verwijderAuto_Null_als_auto_Gooit_exception() {
    garage5autos.verwijderAuto(null);
  }
  
  @Test
  public void test_berekenGemiddeldePrijsPerAuto_Geen_autos_in_showroom_Geeft_0_als_resultaat() {
    org.junit.Assert.assertEquals(0.0D, legeShowroom.berekenGemiddeldePrijsPerAuto(), 0.0D);
  }
  
  @Test
  public void test_berekenGemiddeldePrijsPerAuto_5_autos_in_showroom_Geeft_correct_resultaat() {
    org.junit.Assert.assertEquals(55000.0D, garage5autos.berekenGemiddeldePrijsPerAuto(), 0.0D);
  }
  
  @Test
  public void test_berekenGemiddeldePrijsPerAuto_3_autos_in_showroom_Geeft_correct_resultaat() {
    garage5autos.verwijderAuto(bmw1);
    garage5autos.verwijderAuto(bmw2);
    org.junit.Assert.assertEquals(66000.0D, garage5autos.berekenGemiddeldePrijsPerAuto(), 0.0D);
  }
  
  @Test
  public void test_telAantalAutosVanKleur_Geen_rode_autos_in_showroom_Geeft_0_als_resultaat() {
    org.junit.Assert.assertEquals(0L, garage5autos.telAantalAutosVanKleur("rood"));
  }
  
  @Test
  public void test_telAantalAutosVanKleur_3_zwarte_autos_in_showroom_van_5_autos_Geeft_3_als_resultaat() {
    org.junit.Assert.assertEquals(3L, garage5autos.telAantalAutosVanKleur("zwart"));
  }
  
  @Test
  public void test_telAantalAutosVanKleur_1_witte_autos_in_showroom_van_5_autos_Geeft_1_als_resultaat() {
    org.junit.Assert.assertEquals(1L, garage5autos.telAantalAutosVanKleur("wit"));
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void test_telAantalAutosVanKleur_Null_als_kleur_Gooit_exception() {
    garage5autos.telAantalAutosVanKleur(null);
  }
  
  @Test
  public void test_telAantalAutosVanKleur_Geen_geldige_kleur_namelijk_groen_Geeft_0_als_resultaat() {
    org.junit.Assert.assertEquals(0L, garage5autos.telAantalAutosVanKleur("groen"));
  }
}