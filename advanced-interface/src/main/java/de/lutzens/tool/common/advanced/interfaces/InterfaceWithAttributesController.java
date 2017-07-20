/**
 * Project     : de.lutzens.tool.common.advanced.interface
 * Klasse      : InterfaceWithAttributeController
 * Version     : 1
 * Date        : 30.05.2017 14:31:21
 * Author      : Lutz Hoffarth
 * Copyright(c): Lutz Hoffarth 2017
 */
package de.lutzens.tool.common.advanced.interfaces;

import java.util.Map.Entry;
import java.util.WeakHashMap;

/**
 * Kontrolliert die Zugriffe auf die Attribute des {@link InterfaceWithAttributes}.
 * <p>
 * Attribute, von Objekten die nicht mehr referenziert werden, werden automatisch entfernt.
 * <p>
 * Attribute von Interfaces sind immer öffentliche Konstante 'public static final', auch wenn es nicht angegeben wurde.<br>
 * Die Handhabung ist durch eine statische Instanz von {@link WeakHashMap} geregelt.<p>
 * Mit Zuhilfenahme der {@link WeakHashMap} können Attribute für die jeweiligen Objekte abgelegt werden.<br>
 * Die Einträge der {@link WeakHashMap} werden automatisch vom GarbageCollector entfernt, wenn es keine starke Referenz mehr auf das jeweilige 
 * Object im Schlüssel gibt.
 * <p>
 * @author <a href="mailto:office@lutzens.de">Lutz Hoffarth</a>
 * @since 30.05.2017 14:31:28 Lutz Hoffarth | Realisierung
 * @since 13.07.2017 10:20:09 Lutz Hoffarth | Überarbeitet
 */
class InterfaceWithAttributesController {
  /** @since 30.05.2017 14:31:30 Lutz Hoffarth | Realisierung */
  @SuppressWarnings("unused")
  private static final long                                                        serialVersionUID     = 1L;
  
  /* -- Deklaration ------------------------------------------------------------------------------- */
  /*   -- Konstante ---------------------------------------------------------------- */
  
  /** 
   * Jedes Objekt oder Interface der Spezialisierung des Interfaces kann viele Objekt-Attribute beinhalten.
   * <p>
   * Attribute von Interfaces sind immer öffentliche Konstante 'public static final', auch wenn es nicht angegeben wurde.
   * <p>
   * Mit Zuhilfenahme der {@link WeakHashMap} können Eigenschaften für die jeweiligen Objekte abgelegt werden.<br>
   * Die Einträge der {@link WeakHashMap} werden automatisch vom GarbageCollector entfernt, wenn es 
   * keine starke Referenz mehr auf das jeweilige Object im Schlüssel gibt.
   * <p>
   * Der Controller wird ausschließlich durch die Schnittstelle {@link InterfaceWithAttributes} verwendet.
   * <p>
   * @since 26.10.2014 07:39:41 Lutz Hoffarth | Realisierung 
   * @since 13.07.2017 10:10:40 Lutz Hoffarth | Methoden und Konstante von {@link InterfaceWithAttributes} eingelagert
   */
  private static final WeakHashMap<InterfaceWithAttributes, AttributesOfInterface> OBJECT_ATTRIBUTES    = new WeakHashMap<>();
  
  /** 
   * Jede Klasse oder Interface die {@link InterfaceWithAttributes} spezialisiert, 
   * kann keine oder viele Klassen-Attribute beinhalten.
   * <p>
   * @since 03.12.2014 16:45:46 Lutz Hoffarth | Realisierung */
  private static final WeakHashMap<Class<?>, AttributesOfInterface>                CLASS_ATTRIBUTES     = new WeakHashMap<>();
  
  /** Statische Interface-Attribute die ausschließlich dem Interface {@link InterfaceWithAttributes} zugeordnet sind.
   * <p>
   * Alle Attribute der Schnittstelle sind über jedes Object der Klasse oder des Interfaces, die das Interface implementiert, erreichbar.
   * <p>
   * @since 18.06.2016 09:44:08 Lutz Hoffarth | Realisierung */
  private static final AttributesOfInterface                                       INTERFACE_ATTRIBUTES = new AttributesOfInterface();
  
  ///*   -- Klasse ------------------------------------------------------------------- */
  ///*   -- Instanz ------------------------------------------------------------------ */
  ///* -- Start ------------------------------------------------------------------------------------- */
  ///* -- Konstruktoren ----------------------------------------------------------------------------- */
  /* -- Initialisierung --------------------------------------------------------------------------- */
  
  /**
   * Die Initialisierung wird ausschließlich durch die Schnittstelle {@link InterfaceWithAttributes} verwendet.
   * <p>
   * @param self {@link InterfaceWithAttributesController} die das Interface verwendet.
   * @since 30.05.2017 14:33:23 Lutz Hoffarth | Realisierung
   */
  static void init(InterfaceWithAttributes self) {
    OBJECT_ATTRIBUTES.put(self, new AttributesOfInterface());
    if (!CLASS_ATTRIBUTES.containsKey(self.getClass())) {
      CLASS_ATTRIBUTES.put(self.getClass(), new AttributesOfInterface());
    }
  }
  
  /* -- Logik ------------------------------------------------------------------------------------- */
  
  /**
   * Liefert die zum Objekt gehörigen {@link AttributesOfInterface}s.
   * <p>
   * @return {@link AttributesOfInterface}
   * @since 26.10.2014 07:47:25 Lutz Hoffarth | Realisierung
   * @since 13.07.2017 09:38:57 Lutz Hoffarth | In Controller eingelagert.
   */
  static AttributesOfInterface getObjectAttributes(InterfaceWithAttributes interfaceWithAttributes) {
    AttributesOfInterface value = OBJECT_ATTRIBUTES.get(interfaceWithAttributes);
    if (value == null) OBJECT_ATTRIBUTES.put(interfaceWithAttributes, value = new AttributesOfInterface());
    return value;
  }
  
  ///* -- statisch ---------------------------------------------------------------------------------- */
  /* -- get/set/add/is ---------------------------------------------------------------------------- */
  /* ---- Eigenschaften des Objektes --------------------------------------- */
  
  /**
   * Liefert das Attribute des Objekts mit dem übergebenen Namen.
   * <p>
   * @param key Attributname
   * @return Object
   * @since 22.12.2014 18:59:42 Lutz Hoffarth | Realisierung
   */
  static Object getObjectAttribute(InterfaceWithAttributes interfaceWithAttributes, String key) {
    AttributesOfInterface value = OBJECT_ATTRIBUTES.get(interfaceWithAttributes);
    if (value == null) return null;
    return value.get(key);
  }
  
  /**
   * Setzt den Wert im Objekt-Attribute mit dem übergebenen Namen.
   * <p>
   * @param key Attributname
   * @param value Wert
   * @since 22.12.2014 19:04:43 Lutz Hoffarth | Realisierung
   */
  static void setObjectAttribute(InterfaceWithAttributes interfaceWithAttributes, String key, Object value) {
    getObjectAttributes(interfaceWithAttributes).put(key, value);
  }
  
  /**
   * übernimmt alle Attribute der übergebenen Schnittstelle zu der bestehenden hinzu.
   * <p>
   * @param as {@link InterfaceWithAttributes}
   * @since 18.11.2015 18:17:50 Lutz Hoffarth | Realisierung
   */
  static void addObjectAttributes(InterfaceWithAttributes interfaceWithAttributes, InterfaceWithAttributes as) {
    AttributesOfInterface attributes = getObjectAttributes(as);
    for (Entry<String, Object> e : attributes.get().entrySet()) {
      setObjectAttribute(interfaceWithAttributes, e.getKey(), e.getValue());
    }
  }
  
  /* ---- Statische Eigenschaften der Klasse ------------------------------- */
  
  /**
   * Liefert die zum Interface gehörigen statischen {@link AttributesOfInterface}s.
   * <p>
   * @return {@link AttributesOfInterface}
   * @since 03.12.2014 16:46:47 Lutz Hoffarth | Realisierung
   */
  static AttributesOfInterface getClassAttributes(InterfaceWithAttributes interfaceWithAttributes) {
    AttributesOfInterface value = CLASS_ATTRIBUTES.get(interfaceWithAttributes.getClass());
    if (value == null) CLASS_ATTRIBUTES.put(interfaceWithAttributes.getClass(), value = new AttributesOfInterface());
    return value;
  }
  
  /**
   * Liefert das statische Attribut der Klasse im Interface mit dem übergebenen Namen.
   * <p>
   * @param key Attributname
   * @return Object
   * @since 22.12.2014 19:05:32 Lutz Hoffarth | Realisierung
   */
  static Object getClassAttribute(InterfaceWithAttributes interfaceWithAttributes, String key) {
    AttributesOfInterface value = CLASS_ATTRIBUTES.get(interfaceWithAttributes.getClass());
    if (value == null) return null;
    return value.get(key);
  }
  
  /**
   * Setzt das statische Attribut der Klasse im Interface.
   * <p>
   * @param key Attributname
   * @param value Wert
   * @since 22.12.2014 19:06:07 Lutz Hoffarth | Realisierung
   */
  static void setClassAttribute(InterfaceWithAttributes interfaceWithAttributes, String key, Object value) {
    getClassAttributes(interfaceWithAttributes).put(key, value);
  }
  
  /* ---- Statische Eigenschaften des Interfaces --------------------------- */
  
  /**
   * Liefert die zum Interface gehörigen statischen {@link AttributesOfInterface}s.
   * <p>
   * @return {@link AttributesOfInterface}
   * @since 03.12.2014 16:46:47 Lutz Hoffarth | Realisierung
   */
  static AttributesOfInterface getInterfaceAttributes() {
    return INTERFACE_ATTRIBUTES;
  }
  
  /**
   * Liefert das statische Attribut des Interfaces mit dem übergebenem Namen.
   * <p>
   * @param key Attributname
   * @return Object
   * @since 18.06.2016 10:24:26 Lutz Hoffarth | Realisierung
   */
  static Object getInterfaceAttribute(String key) {
    return INTERFACE_ATTRIBUTES.get(key);
  }
  
  /**
   * Setzt das statische Attribut des Interfaces.
   * <p>
   * @param key Attributname
   * @param value Wert
   * @since 18.06.2016 10:24:26 Lutz Hoffarth | Realisierung
   */
  static void setInterfaceAttribute(String key, Object value) {
    INTERFACE_ATTRIBUTES.put(key, value);
  }
  
  ///* -- create ------------------------------------------------------------------------------------ */
  ///* -- Listener ---------------------------------------------------------------------------------- */
  ///* -- Hilfsmethoden ----------------------------------------------------------------------------- */
  ///* -- Deprecated -------------------------------------------------------------------------------- */
  
}
