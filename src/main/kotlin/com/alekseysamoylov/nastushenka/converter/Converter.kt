package com.alekseysamoylov.nastushenka.converter


interface Converter<T, V> {
  fun convert(valueToConvert: List<T>): List<V>
}
