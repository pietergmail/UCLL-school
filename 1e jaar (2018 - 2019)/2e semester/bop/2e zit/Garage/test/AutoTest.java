import domain.Auto;
import org.junit.Test;

public class AutoTest
{
  private Auto audi;
  
  public AutoTest() {}
  
  @org.junit.Before
  public void setUp() throws Exception
  {
    audi = new Auto("Audi", "rood", 66000.0D);
  }
  
  @Test
  public void test_constructor_Type_BMW_kleur_zwart_en_prijs_88000_Worden_aanvaard() {
    Auto bmw = new Auto("BMW", "zwart", 88000.0D);
    org.junit.Assert.assertEquals("BMW", bmw.getType());
    org.junit.Assert.assertEquals("zwart", bmw.getKleur());
    org.junit.Assert.assertEquals(88000.0D, bmw.getPrijs(), 0.0D);
  }
  
  @Test
  public void test_constructor_Type_Audi_kleur_rood_en_prijs_55000_Worden_aanvaard() {
    Auto audi = new Auto("Audi", "rood", 55000.0D);
    org.junit.Assert.assertEquals("Audi", audi.getType());
    org.junit.Assert.assertEquals("rood", audi.getKleur());
    org.junit.Assert.assertEquals(55000.0D, audi.getPrijs(), 0.0D);
  }
  
  @Test
  public void test_constructor_Type_Mercedes_kleur_wit_en_prijs_111000_Worden_aanvaard() {
    Auto mercedes = new Auto("Mercedes", "wit", 111000.0D);
    org.junit.Assert.assertEquals("Mercedes", mercedes.getType());
    org.junit.Assert.assertEquals("wit", mercedes.getKleur());
    org.junit.Assert.assertEquals(111000.0D, mercedes.getPrijs(), 0.0D);
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void test_constructor_Ongeldig_type_Gooit_Exception() {
    Auto bmw = new Auto("Citroen", "zwart", 35000.0D);
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void test_constructor_Null_als_type_Gooit_Exception() {
    Auto bmw = new Auto(null, "zwart", 35000.0D);
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void test_constructor_Ongeldige_kleur_Gooit_Exception() {
    Auto bmw = new Auto("BMW", "groen", 35000.0D);
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void test_constructor_Null_als_kleur_Gooit_exception() {
    Auto bmw = new Auto("BMW", null, 35000.0D);
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void test_constructor_Prijs_negatief_Gooit_exception() {
    Auto bmw = new Auto("BMW", "zwart", -35000.0D);
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void test_constructor_Prijs_onder_25000_maar_positief_Gooit_exception() {
    Auto bmw = new Auto("BMW", "zwart", 20000.0D);
  }
  
  @Test
  public void test_setKleur_Geldige_kleur_Wordt_aanvaard() {
    audi.setKleur("zilver");
    org.junit.Assert.assertEquals("Audi", audi.getType());
    org.junit.Assert.assertEquals("zilver", audi.getKleur());
    org.junit.Assert.assertEquals(66000.0D, audi.getPrijs(), 0.0D);
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void test_setKleur_Null_als_kleur_Gooit_exception() {
    audi.setKleur(null);
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void test_setKleur_Ongeldige_kleur_Gooit_exception() {
    audi.setKleur("groen");
  }
  
  @Test
  public void test_setPrijs_Geldige_prijs_Wordt_aanvaard() {
    audi.setPrijs(64000.0D);
    org.junit.Assert.assertEquals("Audi", audi.getType());
    org.junit.Assert.assertEquals("rood", audi.getKleur());
    org.junit.Assert.assertEquals(64000.0D, audi.getPrijs(), 0.0D);
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void test_setPrijs_Negatieve_prijs_Gooit_exception() {
    audi.setPrijs(-64000.0D);
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void test_setPrijs_Prijs_onder_25000_maar_positief_Gooit_exception() {
    audi.setPrijs(22000.0D);
  }
}