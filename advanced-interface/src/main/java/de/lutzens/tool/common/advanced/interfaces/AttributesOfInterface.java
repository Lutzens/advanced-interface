/**
 * Project     : LutzensAdvancedInterface
 * Klasse      : AttributesOfInterface
 * Version     : 1
 * Date        : 03.12.2014 16:52:57
 * Author      : Lutz Hoffarth
 * Copyright(c): Lutz Hoffarth 2014
 */
package de.lutzens.tool.common.advanced.interfaces;

import java.util.HashMap;

/**
 * Beinhaltet eine Reihe von Attributen, die inhaltlich durch ihren Namen unterschieden werden.
 * <p>
 * Der Inhalt kann ein beliebiges Objekt oder <code>null</code> sein.
 * Über den Namen (Schlüssel) des Attributes kann auf den Inhalt (Wert) zugegriffen werden.
 * <p>
 * @author <a href="mailto:office@lutzens.de">Lutz Hoffarth</a>
 * @since 26.10.2014 07:39:06 Lutz Hoffarth | Realisierung
 * @see InterfaceWithAttributes
 */
class AttributesOfInterface {
  /** @since 26.10.2014 07:39:09 Lutz Hoffarth | Realisierung */
  @SuppressWarnings("unused")
  private static final long       serialVersionUID = 1L;
  
  /* -- Deklaration ------------------------------------------------------------------------------- */
  /*   -- Klasse ------------------------------------------------------------------- */
  
  /** Zähler für den Objekt-Identifikator.
   * @since 26.10.2014 07:51:37 Lutz Hoffarth | Realisierung */
  private static long             cntId            = 0;
  
  /*   -- Instanz ------------------------------------------------------------------ */
  
  /** Objekt-Identifikator.
   * @since 26.10.2014 07:51:41 Lutz Hoffarth | Realisierung */
  private long                    id               = 0;
  
  /** Beinhaltet die Attribute für das Interface.
   * <p>
   * Die Verwendung der inneren Eigenschaft ermöglicht die individuelle Handhabung der {@link HashMap}.
   * <p>
   * @since 26.10.2014 07:57:36 Lutz Hoffarth | Realisierung */
  private HashMap<String, Object> variables        = new HashMap<>();
  
  /* -- Konstruktoren ----------------------------------------------------------------------------- */
  
  /**
   * Konstruiert ein {@link AttributesOfInterface}.
   * <p>
   * @since 26.10.2014 07:51:24 Lutz Hoffarth | Realisierung
   */
  AttributesOfInterface() {
    init();
  }
  
  /* -- Initialisierung --------------------------------------------------------------------------- */
  
  /**
   * Initialisiert das {@link AttributesOfInterface}.
   * <p>
   * @since 11.06.2016 13:04:01 Lutz Hoffarth | Realisierung
   */
  private void init() {
    this.id = ++cntId;
  }
  
  /* -- get/set/add/is ---------------------------------------------------------------------------- */
  
  /**
   * Liefert den Wert anhand des übergebenen Schlüssels.
   * <p>
   * @param key Attributname
   * @return {@link Object}
   * @since 26.10.2014 07:56:46 Lutz Hoffarth | Realisierung
   */
  Object get(String key) {
    return this.variables.get(key);
  }
  
  /**
   * Liefert die gesamte {@link HashMap} mit sämtlichen Attributen.
   * <p>
   * @return {@link HashMap}&lt;String, Object&gt;
   * @since 19.11.2015 11:34:36 Lutz Hoffarth | Realisierung
   */
  HashMap<String, Object> get() {
    return this.variables;
  }
  
  /**
   * Fügt der {@link HashMap} eine Eigenschaft hinzu oder überschreibt diese.
   * <p>
   * @param key Eindeutiger SChlüssel.
   * @param value Wert
   * @since 26.10.2014 07:55:15 Lutz Hoffarth | Realisierung
   */
  void put(String key, Object value) {
    this.variables.put(key, value);
  }
  
  /**
   * Liefert den Identifikator der Attribute.
   * <p>
   * @return ID der Attribute
   * @since 26.10.2014 07:52:08 Lutz Hoffarth | Realisierung
   */
  long getId() {
    return this.id;
  }
  
}
