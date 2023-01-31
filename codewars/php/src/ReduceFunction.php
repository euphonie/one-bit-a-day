<?php 
namespace Codewars;

class ReduceFunction {
  public static function reduce($nodeList, $function, $initialValue) {
    if ($nodeList == NULL) {
      return $initialValue;
    } 
    if ($nodeList->next == NULL) {
      return $function($nodeList->data, $initialValue);
    } 
    $res = $function($nodeList->data, ReduceFunction::reduce($nodeList->next, $function, $initialValue));
    return $res;
  }
}

?>