function getGiftsToRefill(a1: Array<String>, a2: Array<String>, a3: Array<String>) : Array<String> {
    const getStoreCountMissingStock = 
      (gift: String, arr: Array<Array<String>>) => {
        const exists = arr.reduce((prev: number, a: Array<String>) => {
          return a.indexOf(gift) === -1 ? prev + 1: prev;
        }, 0);
        return exists
      };
    const categories = Array.from(new Set([...a1, ...a2, ...a3]));
  
    return categories.filter(
      (gift: String) => 
        getStoreCountMissingStock(gift, [a1, a2, a3]) > 1
    );
}

const a1 = ['bike', 'car', 'bike', 'bike']
const a2 = ['car', 'bike', 'doll', 'car']
const a3 = ['bike', 'pc', 'pc']

const gifts : Array<String> = getGiftsToRefill(a1, a2, a3);
const response: Array<String> = ['doll', 'pc'];
console.log(gifts.filter((g:String) => response.indexOf(g) === -1).length === 0, true);