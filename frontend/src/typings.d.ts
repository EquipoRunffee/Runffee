declare module '@mapbox/polyline' {
  const polyline: {
    encode(coords: Array<[number, number]>): string;
    decode(encoded: string): number[][];
  };
  export default polyline;
}
