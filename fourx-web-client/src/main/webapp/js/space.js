(function() {
	$.getJSON(
					starmap_url,
					function(json) {
						var starmap = json;		
						var container = document.getElementById('map_container');
						var WIDTH = window.innerWidth, HEIGHT = window.innerHeight;
						var radius = 1, segments = 32, rings = 6;
						var scene = new THREE.Scene();
						var VIEW_ANGLE = 45, ASPECT = WIDTH / HEIGHT, NEAR = 0.1, FAR = 20000;
						var camera = new THREE.PerspectiveCamera(VIEW_ANGLE, ASPECT, NEAR,
								FAR);
						camera.position.z = 200;
						var renderer = new THREE.WebGLRenderer();
						var particles = new THREE.Geometry();
						renderer.setSize(WIDTH, HEIGHT);
						
						for ( var i in starmap.stars) {
							var x = starmap.stars[i]['coordinates']['x'];
							var y = starmap.stars[i]['coordinates']['y'];
							var z = starmap.stars[i]['coordinates']['z'];											
							var containerStar = new THREE.Object3D();
							containerStar.position.x	= x;
							containerStar.position.y	= y;
							containerStar.position.z	= z;
							scene.add(containerStar);
												
							var material	= THREEx.createAtmosphereMaterial()
							material.side	= THREE.FrontSide;
							material.uniforms.glowColor.value.set(spectral_types[starmap.stars[i]['type'].charAt(0)]);
							material.uniforms.coeficient.value	= 0.05;
							material.uniforms.power.value		= 6.0;
							
							var sphereMaterial = new THREE.MeshLambertMaterial({
								color : spectral_types[starmap.stars[i]['type'].charAt(0)]
							});
							var sphere = new THREE.Mesh(new THREE.SphereGeometry(radius,
									segments, segments), material);
							sphere.scale.multiplyScalar(2.5);
							sphere.position.set(x, y, z);
							
							var sphereTextured = new THREE.Mesh(new THREE.SphereGeometry(radius,
									segments, segments),
									new THREE.MeshBasicMaterial({
								map : THREE.ImageUtils.loadTexture('img/'
										+ spectral_types_jpg[starmap.stars[i]['type'].charAt(0)]),
							}));
							sphereTextured.position.set(x, y, z);
							containerStar.add(sphereTextured);
							containerStar.add(sphere);
	
	
						}

						
						var ambientLight = new THREE.AmbientLight(0xffffff);
						scene.add(ambientLight);
						// Background, controls, render
						var backgroundStars = createBackground(10000, 64);
						scene.add(backgroundStars);
						var controls = new THREE.TrackballControls(camera);
						//var controls = new THREE.OrbitControls(camera,renderer.domElement);
						container.appendChild(renderer.domElement);					
						render();
						
						function render() {
							requestAnimationFrame(render);
							renderer.render(scene, camera);
							controls.update();
						}
						
						function createBackground(radius, segments) {
							return new THREE.Mesh(new THREE.SphereGeometry(radius, segments,
									segments), new THREE.MeshBasicMaterial({
								map : THREE.ImageUtils.loadTexture('img/galaxy_starfield.png'),
								side : THREE.BackSide
							}));
						}
					});
}());