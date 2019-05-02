const getCheese = async () => {
	const response = await fetch('/exampleplayer');
	const json = await response.json();
	console.log(json);
	let jsonText = JSON.stringify(json, undefined, 2);
	let childNode = document.createTextNode(jsonText);
	document.getElementById("putcheesehere").appendChild(childNode);
};

document.getElementById("cheeseclicker").addEventListener("click", getCheese);