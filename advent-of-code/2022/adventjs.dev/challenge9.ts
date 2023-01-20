function countTime(leds: Array<number>) : number {
  let count = 0;
  while (leds.indexOf(0) !== -1) {
    leds = leds.map((led: number, index: number) => {
      const previous = index === 0 ? leds[leds.length -1] : leds[index -1];
      return led === 0 && previous === 1 ? 1 : led;
    });
    count++;
  }

  return count * 7;
}

console.log(countTime([0, 1, 1, 0, 1]), 7);

console.log(countTime([0, 0, 0, 1]), 21);