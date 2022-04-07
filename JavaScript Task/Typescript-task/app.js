// interface PointLike{
//     x: number
//     y: number
// }
// interface Point3D {
//     z: number
// }
// interface Named extends PointLike,Point3D{
//     name: String
// }
// // function logPoint(point: PointLike){
// //     console.log(point.x+point.y);
// // }
// function logName(name: Named){
//     console.log(name.name);
//     console.log(name.x);
//     console.log(name.y) 
//     console.log(name.z);
// }
var obj = {
    x: 10,
    y: 20,
    z: 30,
    name: "Sum"
};
// logPoint(obj)
// logName(obj)
console.log(obj);
