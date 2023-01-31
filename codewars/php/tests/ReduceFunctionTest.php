<?php

use PHPUnit\Framework\TestCase;
use Codewars\ReduceFunctionNode;
use Codewars\ReduceFunction;

class ReduceFunctionTest extends TestCase
{
    public function testExamples()
    {
        $this->assertSame(0, ReduceFunction::reduce(NULL, function ($a, $b) {
            return $a + $b;
        }, 0));
        $this->assertSame(6, ReduceFunction::reduce(new ReduceFunctionNode(1, new ReduceFunctionNode(2, new ReduceFunctionNode(3))), function ($a, $b) {
            return $a + $b;
        }, 0));
       $this->assertSame(24, ReduceFunction::reduce(new ReduceFunctionNode(1, new ReduceFunctionNode(2, new ReduceFunctionNode(3, new ReduceFunctionNode(4)))), function ($a, $b) {
            return $a * $b;
        }, 1));
        $this->assertSame("abc", ReduceFunction::reduce(new ReduceFunctionNode("a", new ReduceFunctionNode("b", new ReduceFunctionNode("c"))), function ($a, $b) {
            return $a . $b;
        }, ""));
    }
}
