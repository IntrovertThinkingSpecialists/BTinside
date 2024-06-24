import React, { useState } from 'react';
import { Editor, EditorState, RichUtils } from 'draft-js';
import 'draft-js/dist/Draft.css';

const RichTextEditor = () => {
  const [editorState, setEditorState] = useState(() => EditorState.createEmpty());

  const handleKeyCommand = (command) => {
    const newState = RichUtils.handleKeyCommand(editorState, command);
    if (newState) {
      setEditorState(newState);
      return 'handled';
    }
    return 'not-handled';
  };

  const toggleInlineStyle = (style) => {
    setEditorState(RichUtils.toggleInlineStyle(editorState, style));
  };

  const toggleBlockType = (blockType) => {
    setEditorState(RichUtils.toggleBlockType(editorState, blockType));
  };

  return (
    <>
      <div style={{ marginBottom: '10px' }}>
        <button onMouseDown={(e) => { e.preventDefault(); toggleBlockType('header-one'); }}>H1</button>
        <button onMouseDown={(e) => { e.preventDefault(); toggleBlockType('header-two'); }}>H2</button>
        <button onMouseDown={(e) => { e.preventDefault(); toggleBlockType('header-three'); }}>H3</button>
        <button onMouseDown={(e) => { e.preventDefault(); toggleBlockType('header-four'); }}>H4</button>
        <button onMouseDown={(e) => { e.preventDefault(); toggleInlineStyle('BOLD'); }}><b>B</b></button>
        <button onMouseDown={(e) => { e.preventDefault(); toggleInlineStyle('ITALIC'); }}><i>I</i></button>
        <button onMouseDown={(e) => { e.preventDefault(); toggleInlineStyle('UNDERLINE'); }}><u>U</u></button>
        <button onMouseDown={(e) => { e.preventDefault(); toggleBlockType('blockquote'); }}>"</button>
        <button onMouseDown={(e) => { e.preventDefault(); toggleInlineStyle('CODE'); }}>{`< >`}</button>
      </div>
      <div style={{ border: '1px solid black', minHeight: '400px', padding: '10px' }}>
        <Editor
          editorState={editorState}
          handleKeyCommand={handleKeyCommand}
          onChange={setEditorState}
        />
      </div>
    </>
  );
};

export default RichTextEditor;
