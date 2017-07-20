/**
 * Project     : LutzensAdvancedInterface
 * Klasse      : InterfaceWithAttributesTes
 * Version     : 1
 * Date        : 17.06.2016 22:14:35
 * Author      : Lutz Hoffarth
 * Copyright(c): Lutz Hoffarth 2016
 */
package de.lutzens.tool.common.advanced.interfaces;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * TODO: Kommentieren!
 * @author <a href="mailto:office@lutzens.de">Lutz Hoffarth</a>
 * @since 17.06.2016 22:14:39 Lutz Hoffarth | Realisierung
 */
public class InterfaceWithAttributesTest implements InterfaceWithAttributes {
  /** @since 17.06.2016 22:14:43 Lutz Hoffarth | Realisierung */
  @SuppressWarnings("unused")
  private static final long   serialVersionUID = 1L;
  
  /* -- Deklaration ------------------------------------------------------------------------------- */
  /*   -- Konstante ---------------------------------------------------------------- */
  
  private static final String KEY__TEST_1      = "test.1";
  private static final String KEY__TEST_2      = "test.2";
  private static final String KEY__TEST_3      = "test.3";
  
  ///*   -- Klasse ------------------------------------------------------------------- */
  ///*   -- Instanz ------------------------------------------------------------------ */
  ///* -- Start ------------------------------------------------------------------------------------- */
  ///* -- Konstruktoren ----------------------------------------------------------------------------- */
  /* -- Initialisierung --------------------------------------------------------------------------- */
  
  /**
   * @since 17.06.2016 22:17:56 Lutz Hoffarth | Realisierung
   */
  @Before
  public void initClass() {
    initInterfaceWithAttribute();
    
    setClassAttribute(KEY__TEST_1, "class.0");
    
    setObjectAttribute(KEY__TEST_1, 1);
    setObjectAttribute(KEY__TEST_2, "Hallo");
    
  }
  
  /* -- Logik ------------------------------------------------------------------------------------- */
  /* ---- Eigenschaften des Objektes --------------------------------------- */
  
  /**
   * @since 13.07.2017 10:39:17 Lutz Hoffarth | Realisierung
   */
  @Test
  public void getObjectIdTest() {
    assertEquals(6, getObjectId());
  }
  
  /**
   * @since 13.07.2017 10:46:43 Lutz Hoffarth | Realisierung
   */
  @Test
  public void getObjectAttributesTest() {
    assertEquals(2, getObjectAttributes().size());
    
    setObjectAttribute(KEY__TEST_2, "Hello");
    setObjectAttribute(KEY__TEST_3, "Test");
    
    assertEquals(3, getObjectAttributes().size());
  }
  
  /**
   * @since 17.06.2016 22:17:55 Lutz Hoffarth | Realisierung
   */
  @Test
  public void getObjectAttribute() {
    //    System.out.println("||| " + getObjectAttribute("test1") + " |||");
    //    System.out.println("||| " + getObjectAttribute("test2") + " |||");
    assertEquals(1, getObjectAttribute(KEY__TEST_1));
    assertEquals("Hallo", getObjectAttribute(KEY__TEST_2));
    
    setObjectAttribute(KEY__TEST_2, "- Hallo -");
    
    assertEquals("- Hallo -", getObjectAttribute(KEY__TEST_2));
    assertEquals(1, getObjectAttribute(KEY__TEST_1));
  }
  
  /**
   * @since 13.07.2017 10:45:01 Lutz Hoffarth | Realisierung
   */
  @Test
  public void setObjectAttribute() {
    setObjectAttribute(KEY__TEST_2, "- Hallo -");
    
    assertEquals("- Hallo -", getObjectAttribute(KEY__TEST_2));
    assertEquals(1, getObjectAttribute(KEY__TEST_1));
  }
  
  /* ---- Statische Eigenschaften der Klasse ------------------------------- */
  
  /**
   * @since 13.07.2017 10:49:31 Lutz Hoffarth | Realisierung
   */
  @Test
  public void getClassAttributesTest() {
    assertEquals(1, getClassAttributes().size());
    
    setClassAttribute(KEY__TEST_1, "class.1");
    
    assertEquals(1, getClassAttributes().size());
    
    setClassAttribute(KEY__TEST_2, "class.2");
    
    assertEquals(2, getClassAttributes().size());
  }
  
  /**
   * @since 13.07.2017 10:52:25 Lutz Hoffarth | Realisierung
   */
  @Test
  public void getClassAttribute() {
    assertEquals("class.0", getClassAttribute(KEY__TEST_1));
  }
  
  /* ---- Statische Eigenschaften des Interfaces --------------------------- */
  
  /**
   * @since 13.07.2017 11:21:07 Lutz Hoffarth | Realisierung
   */
  @Test
  public void getInterfaceAttributesTest() {
    assertEquals(0, getInterfaceAttributes().size());
    
    setInterfaceAttribute(KEY__TEST_1, "interface.1");
    
    assertEquals(1, getInterfaceAttributes().size());
    
    setInterfaceAttribute(KEY__TEST_2, "interface.2");
    
    assertEquals(2, getInterfaceAttributes().size());
  }
  
  ///* -- statisch ---------------------------------------------------------------------------------- */
  ///* -- get/set/add/is ---------------------------------------------------------------------------- */
  ///* -- create ------------------------------------------------------------------------------------ */
  ///* -- Listener ---------------------------------------------------------------------------------- */
  ///* -- Hilfsmethoden ----------------------------------------------------------------------------- */
  ///* -- Deprecated -------------------------------------------------------------------------------- */
  
}
