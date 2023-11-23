// 初始化场景、相机和渲染器
const scene = new THREE.Scene();
const camera = new THREE.PerspectiveCamera(
  75,
  window.innerWidth / window.innerHeight,
  0.1,
  1000
);
const renderer = new THREE.WebGLRenderer();
renderer.setSize(window.innerWidth, window.innerHeight);
document.body.appendChild(renderer.domElement);

// 初始化麻将牌
const tiles = [];

for (let i = 0; i < 4; i++) {
  const tileGeometry = new THREE.BoxGeometry(1, 1.6, 0.2);
  const tileMaterial = new THREE.MeshBasicMaterial({ color: 0x00ff00 });
  const tile = new THREE.Mesh(tileGeometry, tileMaterial);
  tile.position.x = i * 2; // 横向排列
  tile.position.z = -5; // 放在屏幕外
  scene.add(tile);
  tiles.push(tile);
}

// 设置相机位置
camera.position.z = 5;

// 渲染循环
function animate() {
  requestAnimationFrame(animate);

  // 旋转麻将牌
  tiles.forEach((tile) => {
    tile.rotation.x += 0.01;
    tile.rotation.y += 0.01;
  });

  renderer.render(scene, camera);
}

animate();
