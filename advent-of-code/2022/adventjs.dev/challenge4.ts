type Box = {l: number, w:number, h:number}
function fitsInOneBox(boxes: Box[]) : boolean {
  const containsBox = (box: Box, other: Box) =>
    (box.h > other.h && box.w > other.w && box.l > other.l)  
  
  for (let i = 0; i < boxes.length; i++) {
    
    const box1 = boxes[i]
    for (let j = 0; j < boxes.length; j ++ ){
      if (i == j) break

      const box2 =boxes[j]
      if (!containsBox(boxes[i], boxes[j]) && !containsBox(boxes[j], boxes[i])){
        return false
      }
    }
  }
  
  return true
}


  if (
    fitsInOneBox([
        { l: 1, w: 1, h: 10 },
        { l: 3, w: 3, h: 12 },
        { l: 2, w: 2, h: 1 },
    ]) != false ) throw new Error("should be false")
  
  if (
    fitsInOneBox([
        { l: 1, w: 1, h: 1 },
        { l: 3, w: 3, h: 3 },
        { l: 2, w: 2, h: 2 },
    ]) != true ) throw new Error("Should be true")

  