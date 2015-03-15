// Some mockjax code to simulate Ajax calls
waterComponentList = []
var waterComponentList = waterComponentList.concat(jointList);
var waterComponentList = waterComponentList.concat(modelTypeList);
var waterComponentList = waterComponentList.concat(waterPumpList);
var waterComponentList = waterComponentList.concat(accessoryList);
var waterComponentList = waterComponentList.concat(filterCartridgeList);

function arrayIntersect(a, b) {
    return $.grep(a, function(i) {
        return $.inArray(i, b) > -1;
    });
}

function arrayToInt(array) {
	var output = [];

	for(var i=0;i<array.length;i++) {
		if(array[i] && !isNaN(+array[i])) output.push(+array[i]);
	}

	return output;
}

function arrayToFloat(array) {
	var output = [];

	for(var i=0;i<array.length;i++) {
		if(array[i] && !isNaN(parseFloat(array[i]))) output.push(parseFloat(array[i]));
	}

	return output;
}

function getWaterComponents(type, brand, name) {
	var _type = [].concat(type),
		_brand = arrayToInt([].concat(brand)),
		_name = arrayToInt([].concat(name));

	return $.grep(waterComponentList, function(item, index) {
		var t = true, b = true, na = true;

		if(_type.length) {
			t = $.inArray(item.ptype, _type) > -1;
		}

		if(_brand.length) {
			b = $.inArray(item.brand, _brand) > -1;
		}

		if(_name.length) {
			na = $.inArray(item.pname, _name) > -1;
		}

		return !!(t && b && na);
	});
}

function getTypes(brand, name) {
	var comps = getWaterComponents(null, brand, name);

	var types = $.map(comps, function(comp) { return comp.ptype; });
	types.sort(asc);
	return arrayUnique(types);
}

function getBrands(type, name) {
	var comps = getWaterComponents(type, null, name);

	var brands = $.map(comps, function(comp) { return comp.brand; });
	brands.sort(asc);
	return arrayUnique(brands);
}

function getNames(type, brand) {
	var comps = getWaterComponents(type, brand, null);

	var names = $.map(comps, function(comp) { return comp.pname; });
	names.sort(asc);
	return arrayUnique(names);
}

function arrayUnique(array) {
	var a = array.concat();
	for(var i=0; i<a.length; ++i) {
		for(var j=i+1; j<a.length; ++j) {
			if(a[i] === a[j])
				a.splice(j--, 1);
		}
	}

	return a;
}

function asc(a, b) {
	return a - b;
}

$.mockjax({
	url: '/api/types',
	contentType: 'application/json; charset=utf-8',
	responseTime: 100,
	response: function(settings){
		this.responseText = JSON.stringify(getTypes(settings.data.brand, settings.data.name));
	}
});

$.mockjax({
	url: '/api/brands',
	contentType: 'application/json; charset=utf-8',
	responseTime: 100,
	response: function(settings){
		this.responseText = JSON.stringify(getBrands(settings.data.type, settings.data.name));
	}
});

$.mockjax({
	url: '/api/names',
	contentType: 'application/json; charset=utf-8',
	responseTime: 100,
	response: function(settings){
		this.responseText = JSON.stringify(getNames(settings.data.type, settings.data.brand));
	}
});

$.mockjax({
	url: '/api/watercomponents',
	contentType: 'application/json; charset=utf-8',
	responseTime: 100,
	response: function(settings){
		this.responseText = JSON.stringify(getWaterComponents(settings.data.type, settings.data.brand, settings.data.name));
	}
});