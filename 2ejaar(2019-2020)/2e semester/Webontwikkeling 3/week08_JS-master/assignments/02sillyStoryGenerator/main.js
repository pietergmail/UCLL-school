

const storyText = "It was 94 farenheit outside, so :insertx: went for a walk. " +
    "When they got to :inserty:, they stared in horror for a few moments, " +
    "then :insertz:. Bob saw the whole thing, but was not surprised — :insertx:" +
    " weighs 300 pounds, and it was a hot day.";

const insertX = ["Willy the Goblin", "Big Daddy", "Father Christmas"];
const insertY = ["the soup kitchen", "Disneyland", "the White House"];
const insertZ = ["spontaneously combusted", "melted into a puddle on the sidewalk", "turned into a slug and crawled away"];

window.addEventListener("load", initPage, false);

function initPage() {
    document.getElementById("randomize").addEventListener("click", result, false);
}


function result() {
    let newStory = storyText;
    let xItem = randomValueFromArray(insertX);
    let yItem = randomValueFromArray(insertY);
    let zItem = randomValueFromArray(insertZ);
    // global replacement of occurence of :insertx:
    newStory = newStory.replace(/:insertx:/g, xItem);
    newStory = newStory.replace(/:inserty:/g, yItem);
    newStory = newStory.replace(/:insertz:/g, zItem);

    var numbers = newStory.match(/\d+/g).map(Number);
    var number1 = numbers[0];
    var number2 = numbers[1];

    if (document.getElementById("be").checked){
        number1 = convertFahrenheitToCentigrade(number1);
        number2 = convertFahrenheitToCentigrade(number2);
    }

    numbers[0] = number1;
    numbers[1] = number2;


    document.getElementsByClassName("story")[0].innerHTML = newStory;

}

function randomValueFromArray(array) {
    return array[Math.floor(Math.random() * array.length)];
}

function convertPoundsToKg(weight) {
    return Math.round(weight / 2);
}

function convertFahrenheitToCentigrade(temp) {
    return Math.round((temp - 32) / 1.8);
}