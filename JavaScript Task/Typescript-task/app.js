// function logPoint(point: PointLike){
//     console.log(point.x+point.y);
// }
function logName(name) {
    console.log(name.name);
    console.log(name.x);
    console.log(name.y);
    console.log(name.z);
}
var obj = {
    x: 10,
    y: 20,
    z: 30,
    name: "Sum"
};
// logPoint(obj)
logName(obj);
