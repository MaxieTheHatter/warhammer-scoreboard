const getExample = async () => {
	const response = await fetch('/exampleplayer');
	const json = await response.json();
	console.log(json);
	let jsonText = JSON.stringify(json, undefined, 2);
	let childNode = document.createTextNode(jsonText);
	document.getElementById("output").appendChild(childNode);
};

function formToJson(form) {
		let obj = {};
		let elements = form.querySelectorAll("input");
		for(let i = 0; i < elements.length; i++) {
			let element = elements[i];
			let name = element.name;
			let value = element.value;
			console.log("trying to add " + value + " to string...")

			if(name) {
				obj[name] = value;
				console.log("added " + value + " to string successfully")
			}
		}
		console.log("Stringying JSON " + JSON.stringify(obj))
		return JSON.stringify(obj, undefined, 2);
}

function playerJson(playerForm, resourceForm) {
	let playerObj = {};
	let playerElements = playerForm.querySelectorAll("input");
	for (let i = 0; i < playerElements.length; i++) {
		let element = playerElements[i];
		let name = element.name;
		let value = element.value;
		console.log("trying to add " + value + " to string...")

		if(name) {
			playerObj[name] = value;
			console.log("added " + value + " to string successfully")
		}
	}

	let resourceObj = {};
	let resourceElements = resourceForm.querySelectorAll("input");
	for (let i = 0; i < resourceElements.length; i++) {
		let element = resourceElements[i];
		let name = element.name;
		let value = element.value;
		console.log("trying to add " + value + " to string...")

		if(name) {
			resourceObj[name] = value;
			console.log("added " + value + " to string successfully")
		}
	}

	playerObj.armyResource = resourceObj;
	return JSON.stringify(playerObj, undefined, 2);
}


let playerForm = document.getElementById("playerForm");
let resourceForm = document.getElementById("resourceForm");
let output = document.getElementById("output");
document.getElementById("save").addEventListener("click", playerJsonToOutput(playerForm, resourceForm, output));
//document.getElementById("save").addEventListener("click", JSONtoOutput(form, output));

function JSONtoOutput(form, field) {
	return function() {
		let json = formToJson(form);
		let childNode = document.createTextNode(json);
		while (field.firstChild) {
			field.removeChild(field.firstChild);
		}
		field.appendChild(childNode);
	}
}

function playerJsonToOutput(playerForm, resourceForm, field) {
	return function () {
		let json = playerJson(playerForm, resourceForm);
		let childNode = document.createTextNode(json);
		while (field.firstChild) {
			field.removeChild(field.firstChild);
		}
		field.appendChild(childNode);
	}
}