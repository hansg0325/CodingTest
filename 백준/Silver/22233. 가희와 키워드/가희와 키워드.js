const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];
rl.on("line", (line) => {
  input.push(line);
}).on("close", () => {
  let [N, M] = input[0].split(" ").map(Number);

  // 🔹 Java의 LinkedHashSet과 유사한 Set 사용 (삽입 순서 유지)
  let keywords = new Set();

  for (let i = 1; i <= N; i++) {
    keywords.add(input[i]);
  }

  let output = [];
  for (let i = N + 1; i <= N + M; i++) {
    let words = input[i].split(",");
    for (let word of words) {
      keywords.delete(word); // ✅ 평균 O(1)으로 삭제
    }
    output.push(keywords.size);
  }

  console.log(output.join("\n"));
  process.exit();
});
